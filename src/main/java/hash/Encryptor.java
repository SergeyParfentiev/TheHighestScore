package hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public String shaStrong(String password) {
        String encryptedText = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte encryptedData[] = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte anEncryptedData : encryptedData) {
                String hex = Integer.toHexString(0xFF & anEncryptedData);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            encryptedText = hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedText;
    }

    private String shaMiddle(String pstrPassword) {
        MessageDigest objMsgDigest = null;
        try {
            objMsgDigest = MessageDigest.getInstance("SHA-1");
            objMsgDigest.update(pstrPassword.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        assert objMsgDigest != null;
        byte byteHash[] = objMsgDigest.digest();
        String strHashPwd = "";
        for (byte aByteHash : byteHash) {
            // for (byte aByteHash : byteHash) {
            strHashPwd += Integer.toHexString(aByteHash & 0xff);
        }
        return strHashPwd;
    }

    private String shaSimple(String plainText) {
        String encryptedText = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(plainText.getBytes("UTF-8"));
            byte[] encryptedData = md.digest(plainText.getBytes());
            encryptedText = new String(encryptedData);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
        }
        return encryptedText;
    }


}
