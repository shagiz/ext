Ext.define('MVC.view.Login', {
    extend: 'Ext.window.Window',
    xtype: 'login',

    requires: [
        'MVC.controller.LoginController',
        'Ext.form.Panel'
    ],

    controller: 'login',
    bodyPadding: 10,
    title: 'Login',
    closable: false,
    autoShow: true,

    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
            xtype: 'textfield',
            name: 'login',
            emptyText: 'Username',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            emptyText: 'Password',
            allowBlank: false
        }],
        buttons: [{
            text: 'Login',
            formBind: true,
            action: 'login'
        },
            {
                text: 'Register',
                listeners: {
                    click: 'onRegisterClick'
                }
            }]
    }
});