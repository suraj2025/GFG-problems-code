<h2><a href="https://www.geeksforgeeks.org/problems/pair-with-greatest-product-in-array3342/1?page=1&category=Arrays,Strings,Linked%20List&difficulty=Easy&status=unsolved&sortBy=submissions">Pair with greatest product in array</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>A</strong> of <strong>N</strong> elements. The task is to find the greatest number <strong>S</strong> such that it is product of two elements of given array (S cannot be included in pair. Also, pair must be from different indices). </span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong>  arr[] = {10, 3, 5, 30, 35}
<strong>Output:</strong>  30
<strong>Explanation:</strong> 30 is the product of 10 and 3.</span></pre>

<div><br>
<span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input :</strong>  arr[] = {2, 5, 7, 8}
<strong>Output:</strong>  -1
<strong>Explanation:</strong> Since, no such element exists.

</span></pre>

<div><span style="font-size:18px"><strong>Example 3:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input  :</strong>  arr[] = {10, 2, 4, 30, 35}
<strong>Output:</strong>  -1
</span></pre>

<div>&nbsp;</div>

<div><span style="font-size:18px"><strong>Example 4:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input :</strong>  arr[] = {10, 2, 2, 4, 30, 35}
<strong>Output:</strong>  4</span></pre>

<div><br>
<span style="font-size:18px"><strong>Example 5:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input  :</strong> arr[] = {17, 2, 1, 35, 30}
<strong>Output :</strong> 35</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>findGreatest()</strong>&nbsp;which takes the array <strong>arr[]</strong> and its size <strong>N </strong>as inputs and returns the answer. If the answer is not present in the array, return <strong>-1</strong>.</span><br>
<br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N. Log(N))<br>
<strong>Expected Auxiliary Space:</strong> O(N)<br>
<br>
<strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>6</sup><br>
1 ≤ A<sub>i</sub> ≤ 10<sup>7</sup></span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Linkedin</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;