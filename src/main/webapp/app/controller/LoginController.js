Ext.define('MVC.controller.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    requires: [
        'MVC.view.Register',
        'MVC.view.Main'
    ],

    views: [
        'MVC.view.Login'
    ],

    store: 'TestStore',

    init: function () {
        this.control({
            'login button[action=login]': {
                click: this.onLoginClick
            }
        });
    },

    /**
     * Получаем данные из формы, отправляем на сервер
     */
    onLoginClick: function (button) {

        var form = button.up('form').getForm();
        var loginData = Ext.encode(form.getValues());
        Ext.Ajax.request({
            url: 'login',
            method: 'POST',
            params: {
                loginData: loginData
            },
            scope: this,
            success: this.onLoginSuccess,
            failure: this.onLoginFailure
        });
    },

    onRegisterClick: function () {
        this.getView().destroy();

        Ext.create({
            xtype: 'register'
        }).show()
    },

    onLoginFailure: function (err) {
        Ext.MessageBox.alert('Ошибка авторизации', 'Please try again!');
    },

    onLoginSuccess: function (response, opts) {
        response = Ext.decode(response.responseText);
        if (response.success) {

            localStorage.isLogged = true;

            this.getView().destroy();

            Ext.create('MVC.view.RadioDialog').show();
        } else {
            Ext.MessageBox.alert('Login failed', response.message);
        }
    }
});