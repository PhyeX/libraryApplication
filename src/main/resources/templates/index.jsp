

<!DOCTYPE html>
<html lang="en" mlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Manage Books</title>
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
                    url:  'http://localhost:8080/api/find/' +id ,
                    success: function (book) {
                        console.log(book.bookId);
                        $('#editBook #bookId').val(book.bookId);

                        $('#editBook #ISBN').val(book.isbn);
                        console.log(book);
                        $('#editBook #nameOfBook').val(book.nameOfBook);
                        $('#editBook #description').val(book.description);
                        $('#editBook #authorName').val(book.authorName);
                        $('#editBook #nameOfPublisher').val(book.nameOfPublisher);
                        $('#editBook #seriesOfBook').val(book.seriesOfBook);

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
                        <h2><i class="material-icons dp48">library_books</i> Manage Books</h2>
                    </div>
                    <div>
                    <form id="formSearch" th:action="@{/index}" method ="get">
                        <input  id ="txtSearch" type = "text" name = "searchText">
                        <button type="submit" >Search</button>
                        <select name="select" id="select" class="responsiveSearch">
                            <option value="bookName">Book Name</option>
                            <option value="authorName">Author</option>
                            <option value="series">Series</option>
                            <option value="ISBN">ISBN</option>
                        </select>
                    </form>
                    </div>
                    <div style="margin-left: 50px;">
                        <a href="#addBook" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Book</span></a>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Book Name</th>
                    <th>Book Subname</th>
                    <th>Book Series</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>ISBN Number</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                 <tr th:each="book : ${books}">
                    <td th:text=${book.nameOfBook}></td>
                    <td th:text=${book.subOfBook}></td>
                    <td th:text=${book.seriesOfBook}></td>
                    <td th:text=${book.authorName}></td>
                    <td th:text=${book.nameOfPublisher}></td>
                    <td th:text=${book.ISBN}></td>
                    <td th:text=${book.description}></td>
                     <td>

                         <a href="#editBook" class="edit" data-toggle="modal"><i class="material-icons" title="Edit">&#xE254;</i></a>

                         <a th:href="@{/delete/{id}(id=${book.bookId})}" class="delete" ><i class="material-icons"  title="Delete">&#xE872;</i></a>
                      <input id="id" type="hidden" th:value="${book.bookId}"/>
                     </td>
                     <input id="id" type="hidden" th:value="${book.bookId}"/>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="addBook" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/create" >
                <div class="modal-header">
                    <h4 class="modal-title">Add Book</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required = "required"   name = "nameOfBook" id="nameOfBook" >
                    </div>
                    <div class="form-group">
                        <label>Subname of Book</label>
                        <input type="text" class="form-control"  name = "subOfBook">
                    </div>
                    <div class="form-group">
                        <label>Series Of Book</label>
                        <input type="text" class="form-control" name = "seriesOfBook">
                    </div>
                    <div class="form-group">
                        <label>Name of the Author</label>
                        <input type="text" class="form-control"  required = "required" name = "authorName">
                    </div>
                    <div class="form-group">
                    <label>Name of the Publisher</label>
                    <input type="text" class="form-control"  required = "required" name = "nameOfPublisher">
                    </div>
                    <div class="form-group">
                    <label>ISBN Number</label>
                    <input type="text" class="form-control"  required = "required" name = "ISBN" placeholder="ISBN number must be 13 digit.">
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
<div id="editBook" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method ="post" action ="/update" >
                <div class="modal-header">
                    <h4 class="modal-title">Edit Book</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required = "required"   name = "nameOfBook" id = "nameOfBook" >
                    </div>
                    <div class="form-group">
                        <label>Subname of Book</label>
                        <input type="text" class="form-control"  name = "subOfBook" id = "subOfBook">
                    </div>
                    <div class="form-group">
                        <label>Series Of Book</label>
                        <input type="text" class="form-control" name = "seriesOfBook" id = "seriesOfBook">
                    </div>
                    <div class="form-group">
                        <label>Name of the Author</label>
                        <input type="text" class="form-control"  required = "required" name = "authorName" id = "authorName">
                    </div>
                    <div class="form-group">
                        <label>Name of the Publisher</label>
                        <input type="text" class="form-control"  required = "required" name = "nameOfPublisher" id = "nameOfPublisher">
                    </div>
                    <div class="form-group">
                        <label>ISBN Number</label>
                        <input type="text" class="form-control"  required = "required" name = "ISBN" id = "ISBN">
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea class="form-control" name = "description" id = "description"></textarea>
                    </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                    <input type="hidden" id="bookId" name="bookId">
                    <input type="hidden" id="id" name="id">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>