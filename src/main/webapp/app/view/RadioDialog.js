Ext.define('MVC.view.RadioDialog', {
    show: function () {

        var radioValue = 0;

        var insertButton = Ext.create('Ext.button.Button', {
            text: 'Ввод данных',
            width: 150,
            height: 35,
            margin: '10 10 10 10',
            handler: function () {
                radioWindow.destroy();
                Ext.create('MVC.view.Main').show();
            }
        });

        var editButton = Ext.create('Ext.button.Button', {
            text: 'Редактирование',
            width: 150,
            height: 35,
            margin: '10 10 10 10',
            handler: function () {
                radioWindow.destroy();

                if (radioValue == 0) {

                } else {
                    Ext.create('MVC.view.Main').showBibliography('edit');
                }
            }
        });

        var exitButton = Ext.create('Ext.button.Button', {
            text: 'Выход',
            width: 150,
            height: 35,
            margin: '10 10 10 10',
            handler: function () {
                localStorage.isLogged = false;
                radioWindow.destroy();
                Ext.create('MVC.view.Login', {
                    renderTo: document.body
                });
            }
        });

        var radioGroup = Ext.create('Ext.form.RadioGroup', {
            width: 200,
            height: 200,
            margin: '50 -20 10 30',
            layout: 'vbox',
            vertical: true,
            items: [
                {boxLabel: 'Соединения', name: 'rb', inputValue: '0', checked: true},
                {boxLabel: 'Литературные ссылки', name: 'rb', inputValue: '1'}
            ],
            listeners: {
                change: function (obj, value) {
                    radioValue = value.rb;
                }
            }
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