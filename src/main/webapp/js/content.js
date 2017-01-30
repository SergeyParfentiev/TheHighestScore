function showOrders() {
    $('#countryId').change(function (event) {
        var cont = document.getElementById('contentBody');
        var loading = document.getElementById('loading');
        cont.innerHTML = loading.innerHTML;
        var countryId = $('#countryId').serialize();

//                $.getJSON('showOrders', countryId, function (data) {
//                    console.log('lol');
//                    console.log(data);
//                });
        $.ajax({
            url: 'showOrders',
            data: countryId,
            type: 'POST',
            async: true,
            statusCode: {
                404: function() {
                    location.href="login";
                }
            },
            success: function (res) {
                if(res === null) {
                    console.log('null1');
                }
                cont.innerHTML = res;
//                $.each(data, function(i, val) {    // обрабатываем полученные данные
//                    /* ... */
//                });
            },

        });
    })
}
function createSpinner(id) {
    var opts = {
        lines: 13, // Число линий для рисования
        length: 0, // Длина каждой линии
        width: 10, // Толщина линии
        radius: 30, // Радиус внутреннего круга
        corners: 1, // Скругление углов (0..1)
        rotate: 0, // Смещение вращения
        direction: 1, // 1: по часовой стрелке, -1: против часовой стрелки
        color: '#000', // #rgb или #rrggbb или массив цветов
        speed: 2.2, // Кругов в секунду
        trail: 17, // Послесвечение
        shadow: false, // Тень(true - да; false - нет)
        hwaccel: false, // Аппаратное ускорение
        className: 'spinner', // CSS класс
        zIndex: 2e9, // z-index (по-умолчанию 2000000000)
        top: '60%', // Положение сверху относительно родителя
        left: '50%' // Положение слева относительно родителя
    };
    var target = document.getElementById(id);
    var spinner = new Spinner(opts).spin(target);
}