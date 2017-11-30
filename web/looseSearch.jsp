<html>

    <head>
        <title>Loose Search</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript">

        function doSearch(){
            //make request to server
            $.getJSON(
                "looseSearch.do",
                { CHARS : $('#searchBox').val() },
                function(data){
                    $('#results').text('');

                    for(var index in data){
                        $('#results').append('<p>' + data[index].title + '</p>');
                    }
                }
            );
        }
        </script>
    </head>
    <body>
        <h1>Loose Search</h1>

        <input type="text" onKeyUp="doSearch();" id="searchBox" />

        <div id="results">
            Results will appear here...
        </div>
    </body>
</html>