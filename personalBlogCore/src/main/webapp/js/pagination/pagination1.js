 $(document).ready(function() {
	 
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
								
														
													});

									$("#grid").jqGrid('navGrid','#pager',
											{edit:false, add:false, del:false, search:true},
											{}, {}, {}, 
											{ 	// search
												sopt:['cn', 'eq', 'ne', 'lt', 'gt', 'bw', 'ew'],
												closeOnEscape: true, 
												multipleSearch: true, 
												closeAfterSearch: true
											}
									);
									$("#grid").navButtonAdd('#pager',
											{ 	caption:"Add", 
												buttonicon:"ui-icon-plus", 
												onClickButton: addRow,
												position: "last", 
												title:"", 
												cursor: "pointer"
											} 
									);
									$("#grid").navButtonAdd('#pager',
											{ 	caption:"Edit", 
												buttonicon:"ui-icon-pencil", 
												onClickButton: editRow,
												position: "last", 
												title:"", 
												cursor: "pointer"
											} 
									);
									
									$("#grid").navButtonAdd('#pager',
										{ 	caption:"Delete", 
											buttonicon:"ui-icon-trash", 
											onClickButton: deleteRow,
											position: "last", 
											title:"", 
											cursor: "pointer"
										} 
									);

									
								
									
						});
						function addRow() {
							alert('test');
						};
						function editRow() {
							alert('edit');
						}
						function deleteRow() {
							// Get the currently selected row
						    var row = $('#grid').jqGrid('getGridParam','selrow');
						    alert(row);
						}
						
});
	        