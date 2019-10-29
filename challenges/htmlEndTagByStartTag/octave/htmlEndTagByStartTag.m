function e = htmlEndTagByStartTag (s)
	e = ['</' strtok(s,'< >')  '>'];
endfunction
%!assert(htmlEndTagByStartTag("<button type='button' disabled>"), "</button>")
%!assert(htmlEndTagByStartTag("<i>"), "</i>")
%!assert(htmlEndTagByStartTag("<div id='my_area' class='data' title='This is a test for title on Div tag'>"), "</div>")
%!assert(htmlEndTagByStartTag("<html>"), "</html>")
%!assert(htmlEndTagByStartTag("<TABLE border='1'>"), "</TABLE>")
%!assert(htmlEndTagByStartTag("<li class='test'>"), "</li>")