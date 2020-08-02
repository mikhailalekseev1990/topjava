// $(document).ready(function () {

function filterMeals() {
    $.ajax({
        url: context.ajaxUrl + "filter",
        type: "GET",
        data: $("#filter").serialize()
    }).done(updateTable);
}

function updateTable(data) {
    context.datatableApi.clear().rows.add(data).draw();
}

function clearFilter() {
    $.ajax({
        url: context.ajaxUrl,
        type: "GET",
    }).done(updateTable);
}

function updateTable(data) {
    context.datatableApi.clear().rows.add(data).draw();
}

$(function () {
    makeEditable({
            ajaxUrl: "user/meals/",
            datatableApi: $("#datatable").DataTable({
                "paging": false,
                "info": true,
                "columns": [
                    {
                        "data": "dateTime"
                    },
                    {
                        "data": "description"
                    },
                    {
                        "data": "calories"
                    },
                    {
                        "defaultContent": "Edit",
                        "orderable": false
                    },
                    {
                        "defaultContent": "Delete",
                        "orderable": false
                    }
                ],
                "order": [
                    [
                        0,
                        "asc"
                    ]
                ]
            })
        }
    );
});