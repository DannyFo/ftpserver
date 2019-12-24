axios.defaults.baseUrl = "'/browse/";

Vue.component('file-create-form', {
    data: function () {
        return {
            fileName: '',
            fileType: '',
        }
    },

    props: {
        currentPath: {
          type: String,
          required: true,
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
        create() {
            let value = {
                fileName: this.fileName,
                fileType: this.fileType,
                currentPath: this.currentPath
            };
            axios.post('/browse', value)
                .then( r => {
                    this.$emit('addNew', r.data);
                    this.fileName = ''
                })
                .catch(error => {
                    console.log(error.response)
                });

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

        '<file-present-row @open="open" v-for="file in files" :key = "file.ID" :file = "file"/>' +
        '</div>',
    created() {
        axios.get('/browse/').then(resp => {
            this.$emit('newData', resp.data)
        })
    },

    methods: {
        open(file) {
            this.$emit('open', file);
        }
    }
});
var app = new Vue({
        el: '#app',
        template: '<div>' +
            '<file-create-form @addNew="setNewData" :current-path="currentPath" />' +
            '<file-present-list @open="openFile" @newData="setNewData" :files="files"/>' +
            '</div>',
        data: {
            currentPath: "" ,
            files: []
        },
         methods: {
            openFile(file) {
                axios.get('/browse/openFolder?uri=' + file.uri).then(r =>  {
                    this.setNewData(r.data);
                })
            },
            setNewData(payload) {
                this.files = payload.filePresentDTOList;
                this.currentPath = payload.currentPath;
            }
        }
    })
;