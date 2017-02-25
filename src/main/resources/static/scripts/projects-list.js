(function () {
    var request = $.ajax( {
        url: '/projects.json'
    });

    request.done(function (projects) { //the HTTP response -> an array of JSON objects
        console.log(projects);

        var i, html = '';

        for (i = 0; i < projects.length; i++) {
            html += '<div><h2>' + projects[i].projectname + '</h2><p>' + projects[i].projectdescription + '</p></div>';
        }

        $('#load-projects').html(html);

    });
})();
//js.