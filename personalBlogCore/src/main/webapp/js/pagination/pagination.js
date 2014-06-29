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
														postData: {},
														loadonce: false,
														gridview : true,
														height : meta.height,
														width : meta.width,
														caption : meta.caption		
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

									//
									$("#grid").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"});
									
						});
						function addRow() {
							$(location).attr('href',addContactUrl);
						};
						function editRow() {
							var row = $('#grid').jqGrid('getGridParam','selrow');
							var url = editContactUrl + row;
							if( row != null ) {
							  $(location).attr('href',url);
							}else{
								$('#msgbox').text('You must select a record first!');
								$('#msgbox').dialog( 
										{	title: 'Error',
											modal: true,
											buttons: {"Ok": function()  {
												$(this).dialog("close");} 
											}
										});
							}
													
						}
						function deleteRow() {
							// Get the currently selected row
						    var row = $('#grid').jqGrid('getGridParam','selrow');

						    // A pop-up dialog will appear to confirm the selected action
							if( row != null ) 
								$('#grid').jqGrid( 'delGridRow', row,
						          	{	url:deleteUrl, 
										recreateForm: true,
									    beforeShowForm: function(form) {
									    	//Change title
									        $(".delmsg").replaceWith('<span style="white-space: pre;">' +
									        		'Delete selected record?' + '</span>');
							            	//hide arrows
									        $('#pData').hide();  
									        $('#nData').hide();
									    },
						          		reloadAfterSubmit:true,
						          		closeAfterDelete: true,
						          		serializeDelData: function (postdata) {
							          	      var rowdata = $('#grid').getRowData(postdata.id);
							          	      // append postdata with any information 
							          	      return {id: postdata.id, oper: postdata.oper, username: rowdata.username};
							          	},
						          		afterSubmit : function(response, postdata) 
										{ 
								            var result = eval('(' + response.responseText + ')');
											var errors = "";
											
								            if (result.success == false) {
												for (var i = 0; i < result.message.length; i++) {
													errors +=  result.message[i] + "<br/>";
												}
								            }  else {
								            	$('#msgbox').text('Entry has been deleted successfully');
												$('#msgbox').dialog( 
														{	title: 'Success',
															modal: true,
															buttons: {"Ok": function()  {
																$(this).dialog("close");} 
															}
														});
							                }
									    	// only used for adding new records
									    	var newId = null;
								        	
											return [result.success, errors, newId];
										}
						          	});
							else {
								$('#msgbox').text('You must select a record first!');
								$('#msgbox').dialog( 
										{	title: 'Error',
											modal: true,
											buttons: {"Ok": function()  {
												$(this).dialog("close");} 
											}
										});
							}
						}
						
});
	        