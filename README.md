# **Mutation Testing on Standard Algorithms (Java)**

*Course: CS731 – Software Testing*
*Authors: MT2024048 Gangasagar HL, MT2024081 Kuldeep Chamoli*

---

## ** Project Overview**

This project performs **Mutation Testing** on real-world Java implementations of popular algorithms.
The source code under test is taken from the GitHub repository **TheAlgorithms/Java**, which contains a wide collection of classical algorithms implemented for learning purposes.

Mutation testing was performed using **PIT (PITest)** inside **IntelliJ IDEA** to evaluate the strength of test cases and to measure the ability of tests to detect faulty code introduced by mutation operators.
All mutants were required to be **strongly killed**, following the problem statement’s requirement. 

---

## ** Project Aim**

The primary aim of this project is to apply **Mutation Testing** on the source code of well-known algorithms and study:

* How small code mutations affect program correctness
* How effectively designed tests kill (detect) these mutants
* Coverage of unit-level and integration-level mutation operators
* Overall mutation scores across algorithm classes (Greedy, Backtracking, Sorting)

The goal is to ensure that algorithms behave correctly even under minor syntactic or logical perturbations.


---

## ** Code Base Tested**

The project uses Java implementations of algorithms from the popular repository:
**TheAlgorithms / Java**

The codebase contained approximately **1592 lines of executable code** (excluding documentation) distributed as follows:

* **Greedy Algorithms:** 599 LOC
* **Backtracking:** 671 LOC
* **Sorting:** 322 LOC


---

## ** Tools & Environment**

* **IntelliJ IDEA** – Primary IDE used for development and testing
* **PIT Mutation Testing Tool (PITest)** – Mutation generation and report visualization
* **PITclipse Plugin** – Integrated PIT into the IDE for easy analysis


---

## ** Testing Strategy: Mutation Testing**

Mutation Testing involves making small changes—called *mutants*—to the source code and verifying whether the test suite can detect the behavioral change.

A mutant is considered:

* **Weakly killed** when the altered statement changes the program *state* but not necessarily the final output
* **Strongly killed** when the final output is different from the original program
  This project uses **strong killing** as required.


---

## ** Levels of Mutation Applied**

### **1. Unit-Level Mutation**

Applied directly on individual functions using operators such as:

* Arithmetic Operator Replacement
* Relational Operator Replacement
* Logical Operator Replacement
* Unary Operator Insertion/Deletion
* Assignment Operator Replacement
* Variable Replacement
* Absolute Value Insertions
* Shift Operator Replacement


### **2. Integration-Level Mutation**

Applied between interacting methods. Operators include:

* **IVPR** – Integration Parameter Variable Replacement
* **IUOI** – Integration Unary Operator Insertion
* **IPEX** – Integration Parameter Exchange
* **IMCD** – Integration Method Call Deletion
* **IREM** – Integration Return Expression Modification


---

## ** Mutation Operators Used (Active Mutators)**

PIT provided several active mutation operators, including:

* CONDITIONALS_BOUNDARY
* INCREMENTS
* INVERT_NEGS
* MATH
* NEGATE_CONDITIONALS
* NULL_RETURNS
* PRIMITIVE_RETURNS
* TRUE_RETURNS
* VOID_METHOD_CALLS
* EXPERIMENTAL_ARGUMENT_PROPAGATION
* EXPERIMENTAL_MEMBER_VARIABLE
* REMOVE_CONDITIONALS_*
* INLINE_CONSTS
* NON_VOID_METHOD_CALLS

A complete list is provided in the report.


---

# ** Mutation Testing Results (Tabulated)**

Below is the exact summary of results obtained across all algorithms.
All data is taken from pages 11–13 of the uploaded project report.


### **Greedy Algorithms**

| Algorithm               | Killed | %    | LOC |
| ----------------------- | ------ | ---- | --- |
| Activity Selection      | 39/44  | 89%  | 51  |
| Bandwidth Allocation    | 33/35  | 94%  | 45  |
| Binary Addition         | 92/95  | 97%  | 55  |
| Coin Change             | 48/50  | 96%  | 30  |
| Digit Separation        | 24/24  | 100% | 38  |
| Egyptian Fraction       | 12/12  | 100% | 39  |
| Fractional Knapsack     | 29/31  | 94%  | 33  |
| Gale Shapley            | 45/52  | 87%  | 44  |
| Job Sequencing          | 61/66  | 92%  | 63  |
| K-Centers               | 38/46  | 83%  | 38  |
| Merge Intervals         | 38/39  | 97%  | 30  |
| Minimizing Lateness     | 28/32  | 88%  | 42  |
| Minimum Waiting Time    | 16/19  | 84%  | 34  |
| Optimal File Merging    | 29/31  | 94%  | 36  |
| Stock Profit Calculator | 15/15  | 100% | 21  |

---

### **Backtracking Algorithms**

| Algorithm                       | Killed | %    | LOC |
| ------------------------------- | ------ | ---- | --- |
| All Paths From Source to Target | 37/42  | 88%  | 61  |
| Combination                     | 42/46  | 91%  | 45  |
| Flood Fill                      | 35/35  | 100% | 25  |
| Hamiltonian Cycle               | 58/67  | 87%  | 49  |
| Maze Recursion                  | 41/46  | 89%  | 37  |
| M-Coloring                      | 55/62  | 89%  | 37  |
| N-Queens                        | 60/62  | 87%  | 54  |
| Parentheses Generator           | 31/31  | 100% | 31  |
| Partitions of a Set             | 60/74  | 81%  | 56  |
| Permutations                    | 17/19  | 89%  | 33  |
| Word Break                      | 27/28  | 96%  | 37  |
| Power Sum                       | 39/49  | 80%  | 43  |
| Subsequence Finder              | 28/30  | 93%  | 36  |
| Word Pattern Matcher            | 76/83  | 92%  | 51  |
| Word Search                     | 96/106 | 91%  | 55  |

---

### **Sorting Algorithms**

| Algorithm       | Killed | %   | LOC |
| --------------- | ------ | --- | --- |
| Bubble Sort     | 40/44  | 91% | 28  |
| Bucket Sort     | 64/66  | 97% | 40  |
| Counting Sort   | 58/60  | 97% | 37  |
| Heap Sort       | 41/47  | 87% | 34  |
| Insertion Sort  | 34/38  | 89% | 28  |
| Merge Sort      | 66/69  | 96% | 50  |
| Priority Queues | 35/40  | 88% | 33  |
| Quick Sort      | 28/31  | 90% | 28  |
| Radix Sort      | 46/48  | 96% | 25  |
| Shell Sort      | 20/23  | 87% | 19  |

---

## ** Final Summary & Insights**

### **1. High Mutation Scores**

Most algorithms achieved **90%+ mutant kills**, indicating strong test coverage and effective detection of injected faults.


### **2. Robustness Across Algorithm Families**

* Greedy algorithms consistently showed **strong resilience**
* Backtracking algorithms showed **excellent coverage**, despite complex recursive logic
* Sorting algorithms demonstrated **high kill ratios**, especially Bucket Sort and Merge Sort

### **3. Strong Killing Achieved**

All mutants were strongly killed, meeting project requirements.

### **4. Wide Range of Mutators Used**

The project integrates both **unit-level** and **integration-level** mutation operators, demonstrating depth in the testing approach.

### **5. Realistic Testing Environment**

Testing on a widely used open-source repository shows practical relevance and applicability.

---

## ** HTML Reports**

The PIT mutation testing tool also produced detailed HTML reports showing:

* Code coverage
* Mutants generated and killed
* Mutation score per class
* Operator-level kill results
  (Screenshots shown in the project report pages 14–16)

