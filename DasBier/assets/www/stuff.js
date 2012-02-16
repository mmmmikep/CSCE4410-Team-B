var toolbar = new Ext.Toolbar({
    dock : 'top',
    title: 'Biergarten'
});

var tabPanel = new Ext.TabPanel({
    dock: 'top',
    styleHtmlContent: true,
    tabBar: {
        dock: 'top',
        layout: {
            pack: 'center'
        }
    },
    defaults: {
        scroll: 'vertical'
    },
    items: [{
        title: 'Das Bier',
        html: 'Dis is where die beer goes',
        
        
    },
    {
        title: 'Das Buddies',
        html: 'Who needs friends?',
        
    },
    {
        title: 'Die Bars',
        html: 'get mo beer',
       
    },
    {
        title: 'Settings',
        html: 'I guess we can have this',
        
    }]
});

new Ext.Application({
    launch: function() {
        new Ext.Panel({
            fullscreen: true,
            dockedItems: [
                toolbar,
                tabPanel
            ],
            layout: 'fit',
            scroll: 'vertical'
        });
    }
});​