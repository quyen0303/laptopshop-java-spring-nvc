<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Dashboard - Admin</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp"></jsp:include>
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp"></jsp:include>
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manager Products</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="/admin/product">Products</a></li>
                                    <li class="breadcrumb-item active">Delete</li>
                                </ol>
                                <div class="container mt-5">
                                    <div class="row">
                                        <div class=" col-12 mx-auto">
                                            <h3>Delete the product with id = ${id}</h3>
                                            <hr />
                                            <div class="alert alert-danger" role="alert">
                                                Are you sure to delete this product?
                                            </div>
                                            <form:form action="/admin/product/delete" method="post"
                                                modelAttribute="newProduct">
                                                <div class="mb-3" style="display: none">
                                                    <label class="form-label">ID: </label>
                                                    <form:input value="${id}" type="text" class="form-control"
                                                        path="id" />
                                                </div>
                                                <button type="submit" class="btn btn-danger">Confirm</button>
                                            </form:form>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp"></jsp:include>
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js"></script>
            </body>

            </html>