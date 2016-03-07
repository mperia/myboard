# myboard

Run GameOfLife as a java application
Run GameOflifeTest as a JUnit Test
Some thought process
Design:
1.	Read Current state
2.	Determine cell’s current state (dead or alive)
3.	Determine future state (dead or alive)
4.	Print future state of grid
5.	Grid size is 8x6 (but, design to take any size)
6.	Rules logic
7.	Determine the number of neighbors (max is 8)
8.	Continue the loop (optional)
9.	Log time taken
10.	Comments
11.	At any time, the source and the target board have to be separate, so the target can be painted based on the source.
Test:
1.	Ensure pattern adheres to specified input (e.g. “+’ for alive “-“ for dead)
2.	Ensure each cell is either alive or dead (no other form)
3.	Ensure the current state is not just one dimensional?
4.	For any given cell position, spit out the current status of that cell and the status of the surrounding cells
5.	For any given cell position, spit out the future state of the cell (dead or live)
6.	Test for ALL alive and ALL dead
7.	Test for all the rules
Enhancements:
1.	Build a nice UI where the user can:
a.	Change the size of the array
b.	Change the start pattern
c.	Specify the number of runs
d.	Start/Stop/Pause the run
e.	Change the color/shape of the live/dead cells
f.	View the log files
g.	g.	Pipe the logs to ELK (Elasticsearch, Logstash, Kibana) stack to “visualize” results.
h.	How would the Graph API look like?

2.	Reduce the number of lines of code
3.	Read from a file
4.	Track one particular cell: how many times it became alive/dead in a certain number of cycles?
5.	Is one position in the grid more advantageous for the cell to live or be dead longer?
6.	Add light and sound effects
7.	Use interfaces, design patterns
8.	Persist to relational or nosql database
9.	Handle ragged arrays
