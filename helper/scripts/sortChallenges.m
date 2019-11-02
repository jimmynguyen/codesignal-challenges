filepath = '../../README.md';
fh = fopen(filepath);
lines = {};
lines{end+1} = fgets(fh);
while isempty(strfind(lines{end}, '| --------- | -------- |'))
	lines{end+1} = fgets(fh);
endwhile
challenges = [];
line = fgets(fh);
while ischar(line)
	% challenges(end+1) = struct('name', strtok(line, '| []'), 'line', line);
	challenges(end+1).name = strtok(line, '| []');
	challenges(end).line = line;
	line = fgets(fh);
endwhile
fclose(fh);
[~, ndx] = sort({challenges.name});
lines = [lines {challenges(ndx).line}];
fh = fopen(filepath, 'w');
fprintf(fh, '%s', strjoin(lines, ''));
fclose(fh);