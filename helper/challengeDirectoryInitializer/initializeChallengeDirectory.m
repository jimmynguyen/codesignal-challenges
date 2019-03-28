function initializeChallengeDirectory(language, challenge, inputTypes, outputType, linkToChallege, testsFilePath)
# usage: initializeChallengeDirectory(language, challenge, inputTypes, outputType, linkToChallege, testsFilePath)
#
# inputs:
#     language - string
#         the programming language for the new directory
#         possible values:
#             'java'
#     challenge - string
#         the name of the challenge in camel case or Pascal case
#     inputTypes - cell array
#         a list of input types
#         possible values:
#             'boolean'
#             'double'
#             'int'
#             'String'
#     outputType - string
#         the output types
#         possible values: see inputTypes
#     linkToChallenge - string
#         url to CodeSignal challenge
#     testsFilePath - string
#         local path to file containing test cases
#
	if strcmp(lower(language), 'java')
		lines = textread('java/Main.java.txt', '%s','delimiter', '\n', 'whitespace', '');
		if challenge(1) >= 'a'
			challenge(1) = upper(challenge(1));
		end
		argsMap = buildArgsMap(challenge, inputTypes, outputType, testsFilePath);
		lines = replaceArgs(lines, argsMap);
		parentPath = '../../challenges/';
		directory = [lower(challenge(1)), challenge(2:end)];
		directoryPath = [parentPath, directory];
		if exist(directoryPath, 'dir')
			error('directory "%s" already exists', directory);
		else
			mkdir(directoryPath);
			fh = fopen([directoryPath, '/', challenge, '.java'], 'w');
			fprintf(fh, '%s\n', lines{:});
			fclose(fh);
			fh = fopen([directoryPath, '/README.md'], 'w');
			fprintf(fh, sprintf('# %s\n\nLink to Challenge: [%s](%s)', directory, linkToChallege, linkToChallege));
			fclose(fh);
			fh = fopen([directoryPath, '/test.sh'], 'w');
			fprintf(fh, sprintf('java -ea %s.java', challenge));
			fclose(fh);
		end
	end

function javaStringFormatArgsMap = buildJavaStringFormatArgsMap()
	javaStringFormatArgsMap.String = '%s';
	javaStringFormatArgsMap.int = '%d';
	javaStringFormatArgsMap.double = '%f';
	javaStringFormatArgsMap.boolean = '%b';

function argsMap = buildArgsMap(challenge, inputTypes, outputType, testsFilePath)
	javaStringFormatArgsMap = buildJavaStringFormatArgsMap();
	argsMap.CLASS_NAME = challenge;
	argsMap.OUTPUT_TYPE = outputType;
	argsMap.METHOD_NAME = [lower(challenge(1)), challenge(2:end)];
	argsMap.OUTPUT_TYPE_STRING_FORMAT_TEMPLATE = javaStringFormatArgsMap.(outputType);

	if outputType(1) >= 'a'
		argsMap.ACTUAL_EXPECTED_COMPARISON = 'actualOutput == expectedOutput[i]';
	else
		argsMap.ACTUAL_EXPECTED_COMPARISON = 'actualOutput.equals(expectedOutput[i])';
	end

	if !exist(testsFilePath)
		error('tests file path "%s" does not exist', testsFilePath);
	end
	testArgs = textread(testsFilePath, '%s','delimiter', '\n', 'whitespace', '');

	argsMap.TEST_OUTPUTS = testArgs{end};
	argsMap.TEST_INPUTS = '';
	argsMap.NUM_TESTS_ASSERTION = '';
	argsMap.METHOD_ARGS = '';
	argsMap.METHOD_ARGS_STRING_FORMAT_TEMPLATE = '';
	argsMap.METHOD_ARGS_STRING_FORMAT_VALUES = '';
	argsMap.METHOD_ARGS_DEFINITION = '';
	for i = 1:length(inputTypes)
		inputType = inputTypes{i};
		argsMap.TEST_INPUTS = [argsMap.TEST_INPUTS, sprintf('%s[] input%d = new %s[] {%s};\n\t\t', inputType, i, inputType, testArgs{i})];
		argsMap.NUM_TESTS_ASSERTION = [argsMap.NUM_TESTS_ASSERTION, sprintf('assert input%d.length == expectedOutput.length : String.format("# input%d = %%d, # expectedOutput = %%d", input%d.length, expectedOutput.length);\n\t\t', i, i, i)];
		argsMap.METHOD_ARGS = [argsMap.METHOD_ARGS, sprintf('input%d[i], ', i)];
		argsMap.METHOD_ARGS_STRING_FORMAT_TEMPLATE = [argsMap.METHOD_ARGS_STRING_FORMAT_TEMPLATE, sprintf('\\"%s\\", ', javaStringFormatArgsMap.(inputType))];
		argsMap.METHOD_ARGS_STRING_FORMAT_VALUES = [argsMap.METHOD_ARGS_STRING_FORMAT_VALUES, sprintf('input%d[i], ', i)];
		argsMap.METHOD_ARGS_DEFINITION = [argsMap.METHOD_ARGS_DEFINITION, sprintf('%s input%d, ', inputType, i)];
	end
	argsMap.TEST_INPUTS(end-2:end) = [];
	argsMap.NUM_TESTS_ASSERTION(end-2:end) = [];
	argsMap.METHOD_ARGS(end-1:end) = [];
	argsMap.METHOD_ARGS_STRING_FORMAT_TEMPLATE(end-1:end) = [];
	argsMap.METHOD_ARGS_STRING_FORMAT_VALUES(end-1:end) = [];
	argsMap.METHOD_ARGS_DEFINITION(end-1:end) = [];

function lines = replaceArgs(lines, argsMap)
	fields = fieldnames(argsMap);
	for i = 1:length(fields)
		field = fields{i};
		lines = strrep(lines, ['[', field, ']'], argsMap.(field));
	end