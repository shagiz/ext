Ext.define('MVC.view.RadioDialog', {
    show: function () {

        var insertButton = Ext.create('Ext.button.Button', {
            text: 'Ввод данных',
            width: 150,
            height: 35,
            margin: '10 10 10 10',
            handler: function () {
                alert('You clicked the button!')
            }
        });

        var editButton = Ext.create('Ext.button.Button', {
            text: 'Редактирование',
            width: 150,
            height: 35,
            margin: '10 10 10 10',
            handler: function () {
                alert('You clicked the button!')
            }
        });

        var exitButton = Ext.create('Ext.button.Button', {
            text: 'Выход',
            width: 150,
            height: 35,
            margin: '10 10 10 10',
            handler: function () {
                alert('You clicked the button!')
            }
        });

        var radioGroup = Ext.create('Ext.form.RadioGroup', {
            width: 200,
            height: 200,
            margin: '50 -20 10 30',
            layout: 'vbox',
            vertical: true,
            items: [
                {boxLabel: 'Соединения', inputValue: '1'},
                {boxLabel: 'Литературные ссылки', inputValue: '2', checked: true}
            ]
        });


        var radioWindow = Ext.create('Ext.window.Window', {

            title: 'Меню',
            width: 390,
            height: 200,
            closable: false,
            autoShow: true,
            layout: 'hbox',
            items: [
                radioGroup,
                {
                    xtype: 'panel',
                    layout: 'vbox',
                    items: [
                        insertButton,
                        editButton,
                        exitButton
                    ]
                }
            ]
        });

        radioWindow.show();
    }
});