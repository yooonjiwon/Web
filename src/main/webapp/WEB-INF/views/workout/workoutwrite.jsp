<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
		<title>writeform</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />

		<jsp:include page="/WEB-INF/views/include/css-script.jsp" />
		<link rel="stylesheet" href="/dieat/resources/styles/buttons.css">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<link rel="stylesheet" href="minified/themes/default.min.css" />
		<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/resources/daumeditor/css/editor.css" charset=utf-8 /> 
		<script type=text/javascript charset=utf-8 src="${pageContext.request.contextPath}/resources/daumeditor/js/editor_loader.js" />

		<script src="minified/jquery.sceditor.bbcode.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			$(function() { //jQuery's main function
				$('a#write').on('click', function(event) {
					$('form#writeform').submit();
					event.preventDefault();// <a>의 기본 기능 수행 막는 명령
				});
			});

			$(function() {
			    // Replace all textarea tags with SCEditor
			    $('textarea').sceditor({
			        plugins: 'bbcode',
			        style: 'minified/jquery.sceditor.default.min.css'
			    });
			});
			
			var config = {
					txHost: '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) http://xxx.xxx.com */
					txPath: '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) /xxx/xxx/ */
					txService: 'sample', /* 수정필요없음. */
					txProject: 'sample', /* 수정필요없음. 프로젝트가 여러개일 경우만 수정한다. */
					initializedId: "", /* 대부분의 경우에 빈문자열 */
					wrapper: "tx_trex_container", /* 에디터를 둘러싸고 있는 레이어 이름(에디터 컨테이너) */
					form: 'tx_editor_form'+"", /* 등록하기 위한 Form 이름 */
					txIconPath: "images/icon/editor/", /*에디터에 사용되는 이미지 디렉터리, 필요에 따라 수정한다. */
					txDecoPath: "images/deco/contents/", /*본문에 사용되는 이미지 디렉터리, 서비스에서 사용할 때는 완성된 컨텐츠로 배포되기 위해 절대경로로 수정한다. */
					canvas: {
			            exitEditor:{
			                /*
			                desc:'빠져 나오시려면 shift+b를 누르세요.',
			                hotKey: {
			                    shiftKey:true,
			                    keyCode:66
			                },
			                nextElement: document.getElementsByTagName('button')[0]
			                */
			            },
						styles: {
							color: "#123456", /* 기본 글자색 */
							fontFamily: "굴림", /* 기본 글자체 */
							fontSize: "10pt", /* 기본 글자크기 */
							backgroundColor: "#fff", /*기본 배경색 */
							lineHeight: "1.5", /*기본 줄간격 */
							padding: "8px" /* 위지윅 영역의 여백 */
						},
						showGuideArea: false
					},
					events: {
						preventUnload: false
					},
					sidebar: {
						attachbox: {
							show: true,
							confirmForDeleteAll: true
						}
					},
					size: {
						contentWidth: 700 /* 지정된 본문영역의 넓이가 있을 경우에 설정 */
					}
				};

				EditorJSLoader.ready(function(Editor) {
					var editor = new Editor(config);
				});
				
				/* 예제용 함수 */
				function saveContent() {
					Editor.save(); // 이 함수를 호출하여 글을 등록하면 된다.
				}

				/**
				 * Editor.save()를 호출한 경우 데이터가 유효한지 검사하기 위해 부르는 콜백함수로
				 * 상황에 맞게 수정하여 사용한다.
				 * 모든 데이터가 유효할 경우에 true를 리턴한다.
				 * @function
				 * @param {Object} editor - 에디터에서 넘겨주는 editor 객체
				 * @returns {Boolean} 모든 데이터가 유효할 경우에 true
				 */
				function validForm(editor) {
					// Place your validation logic here

					// sample : validate that content exists
					var validator = new Trex.Validator();
					var content = editor.getContent();
					if (!validator.exists(content)) {
						alert('내용을 입력하세요');
						return false;
					}

					return true;
				}
				 
				 /**
					 * Editor.save()를 호출한 경우 validForm callback 이 수행된 이후
					 * 실제 form submit을 위해 form 필드를 생성, 변경하기 위해 부르는 콜백함수로
					 * 각자 상황에 맞게 적절히 응용하여 사용한다.
					 * @function
					 * @param {Object} editor - 에디터에서 넘겨주는 editor 객체
					 * @returns {Boolean} 정상적인 경우에 true
					 */
					function setForm(editor) {
				        var i, input;
				        var form = editor.getForm();
				        var content = editor.getContent();

				        // 본문 내용을 필드를 생성하여 값을 할당하는 부분
				        var textarea = document.createElement('textarea');
				        textarea.name = 'content';
				        textarea.value = content;
				        form.createField(textarea);

				        /* 아래의 코드는 첨부된 데이터를 필드를 생성하여 값을 할당하는 부분으로 상황에 맞게 수정하여 사용한다.
				         첨부된 데이터 중에 주어진 종류(image,file..)에 해당하는 것만 배열로 넘겨준다. */
				        var images = editor.getAttachments('image');
				        for (i = 0; i < images.length; i++) {
				            // existStage는 현재 본문에 존재하는지 여부
				            if (images[i].existStage) {
				                // data는 팝업에서 execAttach 등을 통해 넘긴 데이터
				                alert('attachment information - image[' + i + '] \r\n' + JSON.stringify(images[i].data));
				                input = document.createElement('input');
				                input.type = 'hidden';
				                input.name = 'attach_image';
				                input.value = images[i].data.imageurl;  // 예에서는 이미지경로만 받아서 사용
				                form.createField(input);
				            }
				        }

				        var files = editor.getAttachments('file');
				        for (i = 0; i < files.length; i++) {
				            input = document.createElement('input');
				            input.type = 'hidden';
				            input.name = 'attach_file';
				            input.value = files[i].data.attachurl;
				            form.createField(input);
				        }
				        return true;
					}
					 
					 <div><button onclick='saveContent()'>SAMPLE - submit contents</button></div>
					 <!-- End: Saving Contents -->
					 
					 function loadContent() {
							var attachments = {};
							attachments['image'] = [];
							attachments['image'].push({
								'attacher': 'image',
								'data': {
									'imageurl': 'http://cfile273.uf.daum.net/image/2064CD374EE1ACCB0F15C8',
									'filename': 'github.gif',
									'filesize': 59501,
									'originalurl': 'http://cfile273.uf.daum.net/original/2064CD374EE1ACCB0F15C8',
									'thumburl': 'http://cfile273.uf.daum.net/P150x100/2064CD374EE1ACCB0F15C8'
								}
							});
							attachments['file'] = [];
							attachments['file'].push({
								'attacher': 'file',
								'data': {
									'attachurl': 'http://cfile297.uf.daum.net/attach/207C8C1B4AA4F5DC01A644',
									'filemime': 'image/gif',
									'filename': 'editor_bi.gif',
									'filesize': 640
								}
							});
							/* 저장된 컨텐츠를 불러오기 위한 함수 호출 */
							Editor.modify({
								"attachments": function () { /* 저장된 첨부가 있을 경우 배열로 넘김, 위의 부분을 수정하고 아래 부분은 수정없이 사용 */
									var allattachments = [];
									for (var i in attachments) {
										allattachments = allattachments.concat(attachments[i]);
									}
									return allattachments;
								}(),
								"content": document.getElementById("sample_contents_source") /* 내용 문자열, 주어진 필드(textarea) 엘리먼트 */
							});
						}
			
		</script>

</head>

<body>

			<jsp:include page="/WEB-INF/views/include/header.jsp" />

			<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - April 21, 2014!</div>
				<div class="container_12">
					<div class="grid_2">
						<h3>Body Part</h3>
						<ul class="list1 color1">
							<li><a href="#">등</a></li> <hr class="style1">
                            <li><a href="#">가슴</a></li> <hr class="style1">
							<li><a href="#">어깨</a></li> <hr class="style1">
							<li><a href="#">이두</a></li> <hr class="style1">
							<li><a href="#">삼두</a></li> <hr class="style1">
							<li><a href="#">허리</a></li> <hr class="style1">
                            <li><a href="#">복근</a></li> <hr class="style1">
							<li><a href="#">허벅지</a></li> <hr class="style1">
							<li><a href="#">종아리</a></li> <hr class="style1">
						</ul>
						
					</div>
					<div class="grid_8">
                        <br>
                        <button class="button" style="vertical-align:middle; float:right"><span>부위별</span></button>
                        <button class="button" style="vertical-align:middle; float:right"><span>체형별</span></button>
                        <button class="button" style="vertical-align:middle; float:right"><span>분할법</span></button>
                        
                      <input type="text" name="search" placeholder="Search..">
<br>
<br>
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" style="width: 280px" />
						</td>
					</tr>

					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="attach"></td>
					</tr>
					<tr>
					<th>내용</th>
						<td>
						<jsp:include page="/WEB-INF/views/daumeditor/editor.jsp"></jsp:include>
						</td>
					</tr>
				</table>
		        
					 <br><br>
                      <button class="button" id="write" style="vertical-align:middle; float:right; background-color: rgb(116,105,87); font-color:white"><span>글쓰기</span></button>  
				</div>
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
		<jsp:param name="bg-color" value="palegreen" />
        </jsp:include>
	</body>
</html>
