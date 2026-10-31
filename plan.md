# Video Plan

## videoproceessor
- contains the main for video proceessing
- create the output csv
- call a meethod to open the video and process each frame
- - pass in the csv
- - pass in video

## videoProcessorHelpers
- go through each frame 
- get the largest group
- output largest group to csv with time and coordinate
- Call findConnectedGroups
- get the group at index 0 from findConnectedGroups,
- - if no group the add (-1, -1)
- output timestamp and coordinate of largest group
- done
