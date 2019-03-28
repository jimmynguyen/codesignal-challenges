# python script to parse json formatted tests retrieved from CodeSignal by running the extractTests.js script in the browser
import json
from pprint import pprint

def formatArg(arg, argType):
	if argType == 'String':
		arg = '"{}"'.format(arg)
	elif argType == 'int' or argType == 'boolean' or argType == 'double':
		arg = arg
	else:
		raise ValueError('"{}" is not a supported argType'.format(argType))
	return arg

with open('data.json') as f:
	data = json.load(f)

testCases = []
for inputNumber, inputList in enumerate(data['inputs']):
	for testCaseNumber, inputElem in enumerate(inputList):
		inputElem = str(inputElem)
		if len(testCases) <= testCaseNumber:
			testCases.insert(testCaseNumber, [])
		if len(testCases[testCaseNumber]) <= inputNumber:
			testCases[testCaseNumber].insert(inputNumber, [])
		testCases[testCaseNumber][inputNumber] = inputElem.split(': ', 1)[1]

for testCaseNumber, outputElem in enumerate(data['outputs']):
	outputElem = str(outputElem)
	testCases[testCaseNumber].append(outputElem)

# DEFINE argTypes HERE
argTypes = ['int', 'int', 'int', 'boolean']
outputFile = ''
for ndx, argType in enumerate(argTypes):
	args = ''
	for testCase in testCases:
		args += '{}, '.format(formatArg(testCase[ndx], argType))
	outputFile += '{}\n'.format(args[:-2])

f = open('tests.txt', 'w')
f.write(outputFile)
f.close()
