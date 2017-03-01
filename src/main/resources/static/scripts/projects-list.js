(function () {
    var request = $.ajax( {
        url: '/projects.json'
    });

    request.done(function (projects) { //the HTTP response -> an array of JSON objects
        console.log(projects);

        var i, html = '';

        for (i = 0; i < projects.length; i++) {
            html += '<div class="container">' + '<img src="/images/JikanBlack.png" height="150" width="150"/>' + '<h1>Projects</h1>' + '<ul><li><div><h2>' + projects[i].projectname + '</h2><a href="new-task.html"><button>Add Task</button></a><button>Print</button><p>'
                + '</p></div></li></ul></div>';
        }

        $('#load-projects').html(html);

    });
})();