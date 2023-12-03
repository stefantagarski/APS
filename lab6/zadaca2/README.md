Some modified XML code is provided. The modified XML code uses the symbols '[' and ']', to open and close a tag, respectively, instead of the default '<' and '>'. It should be checked if all the tags in the code are nested correctly (if the code is valid) ie. whether each open tag has a corresponding closed tag with the same name at the appropriate place in the code. For simplicity, it is assumed that every open tag must have its own closing tag and that tags have no attributes.

The input is given the number of lines in the code and the XML itself with each tag in a separate line, and the output should print 1 or 0 for a valid or invalid code, respectively.

Explanation: In the modified XML code each open tag is of the form [tagName] and the corresponding closed tag is of the form [/tagName].

An example of properly nested tags in XML is:

[tag1]
[tag2]
Data
[/tag2]
[/tag1]

An example of improperly nested tags in XML is:

[tag1]
[tag2]
Data
[/tag1]
[/tag2]


