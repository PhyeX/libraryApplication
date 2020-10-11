

<!DOCTYPE html>
<html lang="en" mlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Manage Authors</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/myStyle.css">
    <script>
        $(document).ready(function () {

            $('[data-toggle="tooltip"]').tooltip();

            $('table .delete').on('click' , function () {
                var id = $(this).parent().find('#id').val();
                $('#deleteBookModal #bookId').val(id);
            });

            $('table .edit').on('click' , function () {
                var id = $(this).parent().find('#id').val();
                console.log(id);
                $.ajax({
                    type: 'GET' ,
                    url:  'http://localhost:8080/api/find/publisher/' +id ,
                    success: function (Publisher) {
                        console.log(Publisher);
                        $('#editPublisher #name').val(Publisher.name);
                        $('#editPublisher #description').val(Publisher.description);
                        $('#editPublisher #id').val(Publisher.id);

                    }
                });
                console.log(id);
            });

        });
    </script>
</head>
<body>
<div class="container">
    <div class ="containerImage">
        <img th:src="@{images/bookHead.png}" alt="bookHeader" class="responsiveImage">
        <a href="/index"><button class="imageButton button3" style="background:#435d7d">Manage Books</button></a>
        <a href="/authors"><button class="imageButton button1" style="background:#435d7d">Manage Authors</button></a>
        <a href="/publishers"><button class="imageButton button2" style="background:#435d7d">Manage Publishers</button></a>
    </div>
</div>

<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2><i class="material-icons dp48">library_books</i> Manage Publishers </h2>
                    </div>
                    <div style="margin-left: 330px;">
                        <a href="#addPublisher" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Publisher</span></a>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <th>Publisher Name</th>
                <th style="padding-left: 300px "> &nbsp; &nbsp; Description of the Publisher</th>
                <th></th>
                </thead>
                <tbody>

                <tr th:each="publisher : ${publishers}">

                    <td th:text=${publisher.name}></td>
                    <td th:text=${publisher.description}></td>

                    <td>
                        <a href="#editPublisher" class="edit" data-toggle="modal"><i class="material-icons" title="Edit">&#xE254;</i></a>

                        <a th:href="@{/delete/publisher/{id}(id=${publisher.id})}" class="delete" ><i class="material-icons"  title="Delete">&#xE872;</i></a>
                        <input type="hidden" id="id" th:th:value="${publisher.id}"/>
                    </td>
                </tr>


                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="addPublisher" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/create/publisher" >
                <div class="modal-header">
                    <h4 class="modal-title">Add Publisher</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Publisher Name</label>
                        <input type="text" class="form-control" required = "required"   name = "name" id="name" >
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea class="form-control" name = "description"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editPublisher" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method ="post" action ="/update/publisher" >
                <div class="modal-header">
                    <h4 class="modal-title">Edit Publisher</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Publishe Name</label>
                        <input type="text" class="form-control" required = "required"   name = "name" id = "name" >
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea class="form-control" name = "description" id = "description"></textarea>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-info" value="Save">
                        <input type="hidden" id="id" name="id">
                    </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>