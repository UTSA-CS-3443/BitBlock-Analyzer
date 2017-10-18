# BitBlock-Analyzer
The BitBlock-Analyzer is an application designed to parse Java source code to produce statistics about the code and create a visual representation of the code itself in the form of colored pixels.

## Barebone Functionality
- needs to take input from source file (java file)
- Parse over the source file
  - Built in statements will have predefined colors
  - User created statements will have a color that is inherently “flagged” that will then take in a string of alphanumeric colors before having a terminating black color
- Needs to have 1 to 1 mapping between code and bitblock
  - Needs a universal color palette 
- Needs to produce statistics
- Needs to produce a BitBlock
- Display information to GUI
- Have a menu on top
- Needs to allow the user to edit the source file
- Needs to have editor functionality
- Then allow the user to save changes 
- Then re-update the displayed information
- Needs to allow a person to click on the bit block
- Needs to display what code is associated with a bit when clicked on

## Potential additional features
- Handle Multiple files simultaneously
- Have a smaller context menu to edit selected bit(s)
- Allow the user to select multiple bits
- Highlight words in source file according to BitBlock color
- Convert colors to sound and produce a “song”
- Clicking a bit will have source code window jump to that piece of code
- Have "lines" that trace the function calls of the source code
