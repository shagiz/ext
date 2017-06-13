Ext.define('MVC.view.Main', {
    show: function () {

        var element;

        // -------------------------------------------------------------------------------------------------------------

        function extracted() {

            var rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
                clicksToMoveEditor: 2,
                autoCancel: false
            });

            var elementsStore = Ext.create('Ext.data.Store', {
                fields: ['headClue', 'system', 'expert', 'help', {name: 'referat', mapping: 'referat.value'}, 'eClass'],
                autoLoad: true,
                pageSize: 21,
                proxy: {
                    type: 'ajax',
                    method: 'get',
                    url: 'rest/table/elements',
                    api: {
                        create: 'rest/table/elements',
                        update: 'rest/table/elements',
                        destroy: 'rest/table/elements/delete'
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
                    writer: {
                        allowSingle: false,
                        writeAllFields: true
                    },
                    paramsAsJson: true
                },
                remoteFilter: true,
                remoteSort: true
            });

            var elementsToolBar = Ext.widget('pagingtoolbar', {
                store: elementsStore,
                displayInfo: true,
                displayMsg: 'Данных {0} - {1} of {2}'
            });

            var elementsColumns = [
                {
                    dataIndex: "headClue",
                    width: 70,
                    text: "HeadClue"
                },
                {
                    dataIndex: "system",
                    width: 200,
                    text: "Формула соединения",
                    editor: {
                        allowBlank: true
                    },
                    filter: {
                        type: 'string',
                        serializer: function (filter) {
                            return filter.value;
                        }
                    }
                },
                {
                    dataIndex: "help",
                    width: 180,
                    text: "Обозначение соединения",
                    editor: {
                        allowBlank: true
                    },
                    filter: {
                        type: 'string',
                        serializer: function (filter) {
                            return filter.value;
                        }
                    }
                },
                {
                    dataIndex: "expert",
                    width: 200,
                    text: "Эксперты",
                    editor: {
                        allowBlank: true
                    }
                },
                {
                    dataIndex: "eClass",
                    width: 70,
                    text: "Класс",
                    editor: {
                        allowBlank: true
                    }
                },
                {
                    //todo : показывать ?
                    // dataIndex: "referat",
                    width: '100%',
                    text: "Аналитический обзор",
                    editor: {
                        allowBlank: true
                    }
                }
            ];

            var gridElements = Ext.create('Ext.grid.Panel', {
                columns: elementsColumns,
                store: elementsStore,
                bbar: elementsToolBar,
                autoScroll: true,
                plugins: [rowEditor, 'gridfilters'],
                tbar: [
                    {
                        text: 'Добавить новую запись',
                        handler: function () {
                            rowEditing.cancelEdit();

                            var prev = elementsStore.data.items[0].data;
                            var newRow = {};
                            for (var property  in prev) {
                                if (prev.hasOwnProperty(property)) {
                                    newRow[property] = null;
                                }
                            }

                            elementsStore.insert(0, newRow);
                            rowEditing.startEdit(0, 0);
                        }
                    },
                    {
                        text: 'Обновить данные',
                        handler: function () {
                            elementsStore.reload();
                        }
                    },
                    {
                        text: 'Сохранить изменения',
                        handler: function () {
                            // elementsStore.sync();
                        }
                    },
                    {
                        text: 'Удалить запись',
                        handler: function () {
                            var sm = gridElements.getSelectionModel();
                            rowEditing.cancelEdit();
                            elementsStore.remove(sm.getSelection());
                            if (elementsStore.getCount() > 0) {
                                sm.select(0);
                            }
                        }
                    },
                    {
                        text: 'Выбрать',
                        handler: function () {
                            if (gridElements.getSelectionModel().hasSelection()) {
                                var row = gridElements.getSelectionModel().getSelection()[0];
                                element = row.get('headClue');
                                console.log(element);
                                if (store.data && fields && entity) {
                                    store = createStore(fields, entity);
                                    store.load();
                                }
                                elementWin.close();
                            } else {
                                alert('Выберите элемент');
                            }
                        }
                    },
                    '->',
                    {
                        text: 'Выход',
                        handler: function () {
                            elementWin.destroy();
                            viewport.destroy();
                            Ext.create('MVC.view.Login', {
                                renderTo: document.body
                            });
                        }
                    }
                ]
            });

            var elementWin = Ext.create('Ext.window.Window', {

                title: 'Соединения',
                width: Ext.getBody().getViewSize().width * 0.9,
                height: Ext.getBody().getViewSize().height * 0.9,
                closable: false,
                autoShow: true,
                modal: true,
                layout: 'fit',
                items: [
                    gridElements
                ]
            });

            elementWin.show();
        }

        // -------------------------------------------------------------------------------------------------------------

        extracted();

        // -------------------------------------------------------------------------------------------------------------

        var store = {};
        var col = [];
        var entity;
        var fields;

        // -------------------------------------------------------------------------------------------------------------

        var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToMoveEditor: 2,
            autoCancel: false
        });

        function createStore(fields, entity) {
            var url = 'rest/table?entity=' + entity;
            if (element) {
                url += '&headClue=' + element;
            }

            var newStore = Ext.create('Ext.data.Store', {
                fields: fields,
                autoLoad: false,
                pageSize: 30,
                remoteSort: true,
                remoteFilter: true,
                proxy: {
                    type: 'ajax',
                    method: 'get',
                    url: url,
                    batchActions: true,
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
                    writer: {
                        allowSingle: false,
                        writeAllFields: true
                    }
                }
            });
            newStore.on('load', function (st) {
                contentPanel.setTitle('Таблица - ' + entity);
                contentPanel.reconfigure(newStore, col);
                toolbar.bindStore(newStore);
            });

            return newStore;
        }

        // -------------------------------------------------------------------------------------------------------------

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
                    text: 'Выбрать новый элемент',
                    handler: function () {
                        extracted();
                    }
                },
                {
                    text: 'Добавить новую запись',
                    handler: function () {
                        rowEditing.cancelEdit();

                        var prev = store.data.items[0].data;
                        var newRow = {};
                        for (var property  in prev) {
                            if (prev.hasOwnProperty(property)) {
                                if (property === "headClue") {
                                    newRow[property] = element;
                                } else {
                                    newRow[property] = null;
                                }
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
                        store.sync();
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

        // -------------------------------------------------------------------------------------------------------------

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
                    {text: "Пьезоэлектрические коэффициенты", leaf: true, entity: 'PzEl'},
                    {text: "Твердость", leaf: true, entity: 'HardTabl'},
                    {text: "Растворимость", leaf: true, entity: 'SuspTabl'},
                    {text: "Температура плавления", leaf: true, entity: 'PlavTabl'},
                    {text: "Температура Кюри", leaf: true, entity: 'CuryTabl'},
                    {text: "Данные по полиморфным модификациям", leaf: true, entity: ''},
                    {text: "Параметры элементарной ячейки", leaf: true, entity: 'ElemTabl'},
                    {text: "Тепловое расширение", leaf: true, entity: 'HeatExpn'},
                    {text: "Теплопроводность", leaf: true, entity: 'HeatExpn'},
                    {text: "Диэлектрическая проницаемость", leaf: true, entity: 'Dielectr'},
                    {text: "Диэлектрические потери", leaf: true, entity: 'DielDiss'},
                    {text: "Коэффициенты электромеханической связи", leaf: true, entity: 'MechTabl'},
                    {text: "Упругие жесткости (податливости)", leaf: true, entity: 'Elastic1'},
                    {text: "Область оптической прозрачности", leaf: true, entity: 'Wavepure'},
                    {text: "Показатели преломления", leaf: true, entity: 'RefrcInd'},
                    {text: "Коэффициенты Селмейера", leaf: true, entity: 'ConstSel'},
                    {text: "Электрооптические коэффициенты", leaf: true, entity: 'ElOpTabl'},
                    {text: "Нелинейно-оптические коэффициенты", leaf: true, entity: 'NlOpTabl'},
                    {text: "Компоненты тензора Миллера", leaf: true, entity: 'MNOpTabl'},
                    {text: "Упруго(пьезо)оптические коэффициенты", leaf: true, entity: 'EsOpTabl'},
                    {text: "Коэффициенты затухания упругих волн", leaf: true, entity: 'DecrTabl'},
                    {text: "Подписи к рисункам", leaf: true, entity: ''}
                ]
            }
        });

        // КОЛОНКИ -------------------------------------------------------------------------------------------------------------

        treePanel.getSelectionModel().on('select', function (selModel, record) {
            if (record.get('leaf')) {
                entity = record.get('entity');
                Ext.Ajax.request({
                    url: 'rest/table/columns',
                    params: {entity: entity},
                    method: 'GET',
                    success: function (response) {
                        col = JSON.parse(response.responseText);

                        fields = [];
                        col.forEach(function (item) {
                            if (!item.readOnly) {
                                if (item.dataIndex === 'bknumber') {

                                    var bkNumberStore = Ext.create('Ext.data.Store', {
                                        fields: ['bknumber'],
                                        pageSize: 20,
                                        remoteSort: true,
                                        proxy: {
                                            type: 'ajax',
                                            method: 'get',
                                            url: 'rest/table?entity=Biblio',
                                            reader: {
                                                type: 'json',
                                                root: 'data',
                                                totalProperty: 'total'
                                            }
                                        }
                                    });

                                    item.editor = Ext.create('Ext.form.ComboBox', {
                                        store: bkNumberStore,
                                        queryMode: 'remote',
                                        forceSelection: true,
                                        allowBlank: false,
                                        minChars: 1,
                                        displayField: 'bknumber',
                                        queryParam: 'bkNumber',
                                        valueField: 'bknumber'
                                    });

                                } else if (item.dataIndex === 'singCode') {

                                    var singStore = Ext.create('Ext.data.Store', {
                                        fields: ['singClue', 'singType'],
                                        proxy: {
                                            type: 'ajax',
                                            method: 'get',
                                            url: 'rest/table/sing?headClue=' + element
                                        }
                                    });

                                    item.editor =  Ext.create('Ext.form.ComboBox', {
                                        store: singStore,
                                        queryMode: 'local',
                                        forceSelection: true,
                                        allowBlank: false,
                                        minChars: 1,
                                        displayField: 'singType',
                                        valueField: 'singType'
                                    });

                                } else {
                                    item.editor = {
                                        allowBlank: item.allowBlank,
                                        xtype: item.fieldType,
                                        maxLength: item.fieldLength === 0 ? 100 : item.fieldLength
                                    }
                                }
                            }

                            fields.push(item.dataIndex);
                        });

                        store = createStore(fields, entity);
                        store.load();
                    }
                });
            }
        });

        // -------------------------------------------------------------------------------------------------------------

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

        // -------------------------------------------------------------------------------------------------------------

        viewport.show();
    },
    showBibliography: function () {

        var store = {};
        var col = [
            {
                dataIndex: "bknumber",
                width: 100,
                text: "Bknumber",
                editor: {
                    allowBlank: true,
                    readOnly: true
                }
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

        var fields = ["bknumber", "authors", "source", "title"];

        store = Ext.create('Ext.data.Store', {
            fields: fields,
            autoLoad: true,
            remoteSort: true,
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
                writer: {
                    allowSingle: false,
                    writeAllFields: true
                }
            }
        });


        var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToMoveEditor: 1,
            autoCancel: false
        });

        var search = new Ext.create('Ext.form.field.Number', {
            fieldLabel: 'Номер ссылки'
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
                        store.sync();
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
                search,
                {
                    text: 'Поиск',
                    handler: function () {
                        var bkNumber = search.getValue();
                        store.load({
                            params: {
                                bkNumber: bkNumber
                            }
                        });
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