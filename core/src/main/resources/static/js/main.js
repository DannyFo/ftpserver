axios.defaults.baseUrl = "'/browse/";

Vue.component('file-create-form', {
    data: function () {
        return {
            fileName: '',
            fileType: ''
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="fileName" v-model="fileName"/>' +
        '<select name="fileType" v-model="fileType">' +
        '<option value="file">File</option>' +
        '<option value="directory">Directory</option>' +
        '</select>' +
        '<input type="button" value="Create" @click="create"/>' +
        '</div>',
    methods: {
        create: function () {
            var filePresentation = {
                fileName: this.fileName,
                fileType: this.fileType
            };

            axios.post('/browse', {filePresentation}).catch(error => {
                console.log(error.response)
            });
                this.fileName =''
        }
    }
});

Vue.component('file-present-row', {
    props: ['file'],
    data() {
        return {
            test: null,
        }
    },
    template:
        '<div>' +
            '{{file.ID}} <span @click="$emit(`open`, file)"> {{file.fileName}} </span> {{file.fileType}} {{file.size}} {{file.uri}} {{file.countNotes}}' +
        '</div>',
});

Vue.component('file-present-list', {
    props: ['files'],
    template: '<div>' +
            '<file-create-form :files="files"/>'+
            '<file-present-row @open="open" v-for="file in files" :key = "file.ID" :file = "file"/>' +
        '</div>',
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
            axios.get('/browse/openFolder?uri=' + file.uri).then(r => this.files = r.data)
        }
    }
});