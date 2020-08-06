// $(document).ready(function () {

function filterMeals() {
    $.ajax({
        url: context.ajaxUrl + "filter",
        type: "GET",
        data: $("#filter").serialize()
    }).done(updateTableByData);
}

function clearFilter() {
    $.ajax({
        url: context.ajaxUrl,
        type: "GET",
    }).done(updateTableByData);
}

function updateTableByData(data) {
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
                    "desc"
                ]
            ]
        }),
        updateTable: filterMeals
    });
});