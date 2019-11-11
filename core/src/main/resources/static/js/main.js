axios.defaults.baseUrl = "'/browse/";

Vue.component('file-present-row',{
    props:['file'],
    data() {
        return {
            test: null,
        }
    },
    template:'<div @click="$emit(`open`, file)">{{file.ID}} {{file.fileName}} {{file.fileType}} {{file.size}} {{file.uri}} {{file.countNotes}}</div>',
});

Vue.component('file-present-list', {
    props:['files'],
    template: '<div><file-present-row @open="open" v-for="file in files" :key = "file.ID" :file = "file"/></div>',
    created: function () {
        axios.get('/browse/').then(resp => {
            resp.data.forEach(f => this.files.push(f))
        })
    },
        // browserApi.get().then(result =>
        // result.json().then(data=>
        //     data.forEach(file=>this.files.push(file))
        // ))
    methods: {
        open(file) {
            this.$emit('open', file);
        }
    }
});
var app = new Vue({
    el: '#app',
    template: '<file-present-list @open="openFile" :files="files"/>',
    data: {
        files: []
    },
    methods: {
        openFile(file) {
            console.log(file.uri);
            axios.get('/browse/openFolder/'+file.uri).then( r => this.files = r.data)
        }
    }
});