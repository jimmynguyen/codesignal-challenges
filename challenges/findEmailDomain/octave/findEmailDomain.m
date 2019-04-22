function res = findEmailDomain (address)
	ndx = strfind(address, '@');
	res = address(ndx(end)+1:end);
endfunction
%!assert(findEmailDomain("prettyandsimple@example.com"), "example.com")
%!assert(findEmailDomain("fully-qualified-domain@codesignal.com"), "codesignal.com")
%!assert(findEmailDomain("\" \"@space.com"), "space.com")
%!assert(findEmailDomain("someaddress@yandex.ru"), "yandex.ru")
%!assert(findEmailDomain("\" \"@xample.org"), "xample.org")
%!assert(findEmailDomain("\"much.more unusual\"@yahoo.com"), "yahoo.com")
%!assert(findEmailDomain("\"very.unusual.@.unusual.com\"@usual.com"), "usual.com")
%!assert(findEmailDomain("admin@mailserver2.ru"), "mailserver2.ru")
%!assert(findEmailDomain("example-indeed@strange-example.com"), "strange-example.com")
%!assert(findEmailDomain("very.common@gmail.com"), "gmail.com")