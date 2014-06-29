 $(document)
			.ready(
					function() {
						$(function() {
							$("#grid").jqGrid(
											{
												url : url,
												datatype : 'json',
												mtype : 'POST',
												colNames : columnNames,
												colModel : colModel,
												jsonReader : {
													root : "dataList",
													page : "currentPage",
													total : "totalPages",
													records : "totalRecords",
													repeatitems : false,
													cell : "cell",
													id : "id"
												},
												pager : '#pager',
												rowNum : meta.rowNum,
												autowidth: true,
												rownumbers: true,
												rowList : [ 10, 20, 30,50 ],
												sortname : sortName,
												sortorder : meta.sortOrder,
												viewrecords : true,
												gridview : true,
												height : meta.height,
												width : meta.width,
												caption : meta.caption,
												onSelectRow : function(id) {
													var editId = parseFloat(id);
													document.location.href = 'http://localhost:9090/proof-of-concept/contact/'+ editId;
												}
											}).navGrid('#pager',{edit:false,add:false,del:false}); 
						});
					});
	        