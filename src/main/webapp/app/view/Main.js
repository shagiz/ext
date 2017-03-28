Ext.define('MVC.view.Main', {
    show: function () {
        var store = {};
        var col = [];
        var entity;

        function createStore(fields, entity) {
            return Ext.create('Ext.data.Store', {
                fields: fields,
                autoLoad: false,
                pageSize: 30,
                proxy: {
                    type: 'ajax',
                    method: 'get',
                    url: 'rest/table?entity=' + entity,
                    api: {
                        create: 'rest/table/' + entity,
                        update: 'rest/table/' + entity,
                        destroy: 'rest/table?entity=' + entity
                    },
                    actionMethods: {
                        create: 'POST',
                        read: 'GET',
                        update: 'POST',
                        destroy: 'GET'
                    },
                    reader: {
                        type: 'json',
                        root: 'data',
                        totalProperty: 'total'
                    },
                    paramsAsJson: true
                }
            })
        }


        var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToMoveEditor: 1,
            autoCancel: false
        });

        var toolbar = Ext.widget('pagingtoolbar', {
            store: store,
            displayInfo: true,
            displayMsg: 'Данных {0} - {1} of {2}'
        });

        var contentPanel = Ext.create('Ext.grid.Panel', {
            title: 'Таблица',
            region: 'center',
            store: store,
            columns: col,
            autoScroll: true,
            bbar: toolbar,
            plugins: [rowEditing],
            tbar: [
                {
                    text: 'Добавить новую запись',
                    handler: function () {
                        rowEditing.cancelEdit();

                        var prev = store.data.items[0].data;
                        var newRow = {};
                        for (var property  in prev) {
                            if (prev.hasOwnProperty(property)) {
                                newRow[prev[property]] = null;
                            }
                        }

                        store.insert(0, newRow);
                        rowEditing.startEdit(0, 0);
                    }
                },
                {
                    text: 'Обновить данные',
                    handler: function () {
                        store.reload();
                    }
                },
                {
                    text: 'Сохранить изменения',
                    handler: function () {
                        // store.sync();
                    }
                },
                {
                    text: 'Удалить запись',
                    handler: function () {
                        var sm = contentPanel.getSelectionModel();
                        rowEditing.cancelEdit();
                        store.remove(sm.getSelection());
                        if (store.getCount() > 0) {
                            sm.select(0);
                        }
                    }
                },
                '->',
                {
                    xtype: 'triggerfield',
                    trigger1Cls: Ext.baseCSSPrefix + 'form-clear-trigger',
                    trigger2Cls: Ext.baseCSSPrefix + 'form-search-trigger'
                }
            ]
        });

        var treePanel = Ext.create('Ext.tree.Panel', {
            id: 'tree-panel',
            title: 'Категории базы данных',
            region: 'north',
            height: '100%',
            minSize: 150,
            rootVisible: false,
            autoScroll: true,
            root: {
                expanded: true,
                children: [
                    {text: "Акустооптические свойства", leaf: true, entity: 'Acop'},
                    {text: "Область гомогенности соединения", leaf: true, entity: 'Sist'},
                    {text: "Теплоемкость", leaf: true, entity: 'Heat'},
                    {text: "Плотность", leaf: true, entity: 'Density'},
                    {text: "Пьезоэлектрические коэффициенты", leaf: true},
                    {text: "Твердость", leaf: true},
                    {text: "Растворимость", leaf: true},
                    {text: "Температура плавления", leaf: true},
                    {text: "Температура Кюри", leaf: true},
                    {text: "Данные по полиморфным модификациям", leaf: true},
                    {text: "Параметры элементарной ячейки", leaf: true},
                    {text: "Тепловое расширение", leaf: true},
                    {text: "Теплопроводность", leaf: true},
                    {text: "Диэлектрическая проницаемость", leaf: true},
                    {text: "Диэлектрические потери", leaf: true},
                    {text: "Коэффициенты электромеханической связи", leaf: true},
                    {text: "Упругие жесткости (податливости)", leaf: true},
                    {text: "Область оптической прозрачности", leaf: true},
                    {text: "Показатели преломления", leaf: true},
                    {text: "Коэффициенты Селмейера", leaf: true},
                    {text: "Электрооптические коэффициенты", leaf: true},
                    {text: "Нелинейно-оптические коэффициенты", leaf: true},
                    {text: "Компоненты тензора Миллера", leaf: true},
                    {text: "Упруго(пьезо)оптические коэффициенты", leaf: true},
                    {text: "Коэффициенты затухания упругих волн", leaf: true},
                    {text: "Подписи к рисункам", leaf: true}
                ]
            }
        });

        treePanel.getSelectionModel().on('select', function (selModel, record) {
            if (record.get('leaf')) {
                entity = record.get('entity');
                Ext.Ajax.request({
                    url: 'rest/table/columns',
                    params: {entity: entity},
                    method: 'GET',
                    success: function (response) {
                        col = JSON.parse(response.responseText);

                        var fields = [];
                        col.forEach(function (item) {
                            item.editor = {allowBlank: true};
                            fields.push(item.dataIndex);
                        });

                        store = createStore(fields, entity);

                        store.on('load', function (st) {
                            contentPanel.setTitle('Таблица - ' + entity);
                            contentPanel.reconfigure(store, col);
                            toolbar.bindStore(store);
                        });

                        store.load();
                    }
                });
            }
        });

        var viewport = Ext.create('Ext.Viewport', {
            layout: 'border',
            title: ' Панель работы с БД',
            style: 'background: #efefe8',
            items: [{
                xtype: 'box',
                id: 'header',
                region: 'north',
                html: '<h1> Панель работы с БД</h1>',
                height: 50
            }, {
                layout: 'border',
                id: 'layout-browser',
                region: 'west',
                border: false,
                split: true,
                margins: '2 0 5 5',
                width: 290,
                minSize: 100,
                maxSize: 500,
                items: [treePanel]
            },
                contentPanel
            ],
            renderTo: Ext.getBody()
        });

        viewport.show();
    },
    showBibliography: function (type) {

        if (type == 'edit') {

            var field = Ext.create('Ext.form.field.Number', {

                labelWidth: 180,
                margin: '10 10 10 10',
                fieldLabel: 'Номер литературной ссылки'
            });
            var number = Ext.create('Ext.window.Window', {

                title: 'BkNumber',
                width: 400,
                height: 120,
                closable: false,
                autoShow: true,
                modal: true,
                items: [
                    field,
                    {
                        xtype: 'button',
                        text: 'Принять',
                        margin: '0 0 10 10',
                        handler: function () {
                            number.destroy();
                            viewport.destroy();
                            Ext.create('MVC.view.Login', {
                                renderTo: document.body
                            });
                        }
                    },
                    {
                        xtype: 'button',
                        text: 'Назад',
                        margin: '0 10 10 10',
                        handler: function () {
                            number.destroy();
                            viewport.destroy();
                            Ext.create('MVC.view.Login', {
                                renderTo: document.body
                            });
                        }
                    }
                ]
            });

            number.show();
        }

        var store = {};
        var col = [
            {
                dataIndex: "bknumber",
                width: 100,
                text: "Bknumber"
            },
            {
                dataIndex: "authors",
                width: 600,
                text: "Authors",
                editor: {
                    allowBlank: true
                }
            },
            {
                dataIndex: "source",
                width: 600,
                text: "Source",
                editor: {
                    allowBlank: true
                }
            },
            {
                dataIndex: "title",
                width: 1200,
                text: "Title",
                editor: {
                    allowBlank: true
                }
            }
        ];
        var entity = 'Biblio';

        var fields = [
            {dataIndex: "bknumber"},
            {dataIndex: "authors"},
            {dataIndex: "source"},
            {dataIndex: "title"}
        ];

        store = Ext.create('Ext.data.Store', {
            fields: fields,
            autoLoad: true,
            pageSize: 30,
            proxy: {
                type: 'ajax',
                method: 'get',
                url: 'rest/table?entity=' + entity,
                api: {
                    create: 'rest/table/' + entity,
                    update: 'rest/table/' + entity,
                    destroy: 'rest/table?entity=' + entity
                },
                actionMethods: {
                    create: 'POST',
                    read: 'GET',
                    update: 'POST',
                    destroy: 'GET'
                },
                reader: {
                    type: 'json',
                    root: 'data',
                    totalProperty: 'total'
                },
                paramsAsJson: true
            }
        });


        var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToMoveEditor: 1,
            autoCancel: false
        });

        var toolbar = Ext.widget('pagingtoolbar', {
            store: store,
            displayInfo: true,
            displayMsg: 'Данных {0} - {1} of {2}'
        });

        var contentPanel = Ext.create('Ext.grid.Panel', {
            title: 'Таблица',
            region: 'center',
            store: store,
            columns: col,
            autoScroll: true,
            bbar: toolbar,
            plugins: [rowEditing],
            tbar: [
                {
                    text: 'Добавить новую запись',
                    handler: function () {
                        rowEditing.cancelEdit();

                        var prev = store.data.items[0].data;
                        var newRow = {};
                        for (var property  in prev) {
                            if (prev.hasOwnProperty(property)) {
                                newRow[prev[property]] = null;
                            }
                        }

                        store.insert(0, newRow);
                        rowEditing.startEdit(0, 0);
                    }
                },
                {
                    text: 'Обновить данные',
                    handler: function () {
                        store.reload();
                    }
                },
                {
                    text: 'Сохранить изменения',
                    handler: function () {
                        // store.sync();
                    }
                },
                {
                    text: 'Удалить запись',
                    handler: function () {
                        var sm = contentPanel.getSelectionModel();
                        rowEditing.cancelEdit();
                        store.remove(sm.getSelection());
                        if (store.getCount() > 0) {
                            sm.select(0);
                        }
                    }
                },
                '->',
                {
                    text: 'Выход',
                    handler: function () {
                        viewport.destroy();
                        Ext.create('MVC.view.Login', {
                            renderTo: document.body
                        });
                    }
                }
            ]
        });

        var treePanel = Ext.create('Ext.tree.Panel', {
            id: 'tree-panel',
            title: 'Категории базы данных',
            region: 'north',
            height: '100%',
            minSize: 150,
            rootVisible: false,
            autoScroll: true,
            root: {
                expanded: true,
                children: [
                    {text: "Литературные ссылки", leaf: true, entity: 'Bibliogr'}
                ]
            }
        });

        var viewport = Ext.create('Ext.Viewport', {
            layout: 'border',
            title: ' Панель работы с БД',
            style: 'background: #efefe8',
            items: [{
                xtype: 'box',
                id: 'header',
                region: 'north',
                html: '<h1> Панель работы с БД</h1>',
                height: 50
            }, {
                layout: 'border',
                id: 'layout-browser',
                region: 'west',
                border: false,
                split: true,
                margins: '2 0 5 5',
                width: 290,
                minSize: 100,
                maxSize: 500,
                items: [treePanel]
            },
                contentPanel
            ],
            renderTo: Ext.getBody()
        });

        viewport.show();
    }
});