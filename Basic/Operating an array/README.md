<h2><a href="https://www.geeksforgeeks.org/problems/operating-an-array/1?page=1&category=Arrays,Strings,Linked%20List&difficulty=Basic&status=unsolved&sortBy=submissions">Operating an array</a></h2><h3>Difficulty Level : Basic</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array <strong>A</strong> of size <strong>N</strong>, your task is to do some operations, i.e., search an element <strong>x</strong>, insert an element <strong>y </strong>at index <strong>yi</strong>, and delete the first occurence of element <strong>z </strong>in the array by completing the functions.&nbsp;</span></p>
<p><span style="font-size: 18px;"><strong>Note:&nbsp;</strong></span></p>
<ul>
<li><strong>0-based&nbsp;</strong>indexing is followed.</li>
<li><strong>searchEle </strong>function should return a boolean value. It returns true if the element is found in the array, else return false.</li>
<li><strong>insertEle </strong>function should insert the element <strong>y </strong>at index <strong>yi</strong>. 1 will be printed if the insertion is done in correct way, else, 0 is printed.</li>
<li><strong>deleteEle&nbsp;</strong>should delete the first occurence of element <strong style="font-size: 18px;">z&nbsp;</strong>in the array. If&nbsp;<strong>z&nbsp;</strong>is not present in the array, return false, else, return true.</li>
</ul>
<p><strong><span style="font-size: 18px;">Input Format:<br>N<br>A<sub>1</sub> A</span><sub><span style="font-size: 15px;">2</span></sub><span style="font-size: 18px;"> . . . A</span><sub>n</sub><br><span style="font-size: 18px;">x y yi z</span></strong></p>
<pre><strong><span style="font-size: 18px;">Example:</span><span style="font-size: 18px;">
Input:</span></strong>
<span style="font-size: 18px;">5
</span><span style="font-size: 18px;">2 4 1 0 2
</span><span style="font-size: 18px;">1 2 2 0
</span><strong>
Output:</strong>
<span style="font-size: 18px;">1 1 1<br><strong>Explaination:<br></strong>As, x=1 is present in the array, so return 1.<br>After inserting y=2 at yi=2th index, the array becomes 2,4,2,1,0,2, thus, return 1.<br>After deleting z=2, the array becomes 4,2,1,0,2, so, return 1.</span></pre>
<p><strong><span style="font-size: 18px;">Your Task:</span></strong><br><span style="font-size: 18px;">Since this is a function problem, you only need to complete the provided functions.</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= T &lt;= 100<br>1 &lt;= N &lt;= 1000<br>1 &lt;= x,y,z&lt;= 1000<br>0 &lt;= y</span><sub>i</sub><span style="font-size: 18px;">&lt; N<br></span><span style="font-size: 18px;">0 &lt;= A<sub>i</sub>&nbsp;&lt;= 1000</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;