(function () {
    var request = $.ajax( {
        url: '/projects.json'
    });

    request.done(function (projects) { //the HTTP response -> an array of JSON objects
        console.log(projects);

        var i, html = '';

        for (i = 0; i < projects.length; i++) {
            html += '<ul><li><div><h2>' + projects[i].projectname + '</h2><a class="button-primary" href="/projects/' + projects[i].id + '/tasks/new"><button>Add Task</button></a><button>Print</button><p>'
                + '</p></div></li></ul></div>';
        }

        $('#load-projects').html(html);

    });
})();