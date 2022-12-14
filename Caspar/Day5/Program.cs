// See https://aka.ms/new-console-template for more information
using System.Text;

string[] input = File.ReadAllLines("input.txt");
List<string> stacksLines = new List<string>();
List<string> stepsLines = new List<string>();
SortedDictionary<int, Stack<char>> stacks = new SortedDictionary<int, Stack<char>>();
SortedDictionary<int, Stack<char>> stacksPt2 = new SortedDictionary<int, Stack<char>>();
bool readingStacks = true;

// Split the input into two chunks of lines for the initial state and steps
foreach (string line in input)
{
    if (String.IsNullOrWhiteSpace(line))
        readingStacks = false;
    // else if so that the blank line is skipped
    else if (readingStacks) 
        stacksLines.Add(line);
    else 
        stepsLines.Add(line);
}

// Parse the initial state of the stacks, bottom up, so they come out in the right order
for (int l = stacksLines.Count - 1; l >= 0; l--)
{
    string line = stacksLines[l];
    for (int i = 0; i < line.Length; i++)
    {
        if (char.IsLetter(line[i]))
        {
            int index = (i+3) / 4;
            AddOrInitialize(stacks, index, line[i]);
            AddOrInitialize(stacksPt2, index, line[i]);
        }
    }
}

// Execute the steps
foreach (string line in stepsLines)
{
    // Line format: "move X from Y to Z"
    int popsToDo, fromStack, toStack;
    popsToDo = int.Parse(line.Split(" ")[1]);
    fromStack = int.Parse(line.Split(" ")[3]);
    toStack = int.Parse(line.Split(" ")[5]);

    for (int i = 0; i < popsToDo; i++)
    {
        stacks[toStack].Push(stacks[fromStack].Pop());
        stacksPt2[toStack].Push(stacksPt2[fromStack].Pop());
    }
    ReverseStackNDeep(stacksPt2[toStack], popsToDo);
}

// Print the results, top value of each stack
StringBuilder sb = new StringBuilder();
foreach (var kvp in stacks)
{
    sb.Append(kvp.Value.Peek());
}
System.Console.WriteLine("Part 1: " + sb.ToString());

sb.Clear();
foreach (var kvp in stacksPt2)
{
    sb.Append(kvp.Value.Peek());
}
System.Console.WriteLine("Part 2: " + sb.ToString());

// Helper functions
void AddOrInitialize(SortedDictionary<int, Stack<char>> dict, int k, char v)
{
    if (dict.TryGetValue(k, out var s))
        s.Push(v);
    else
        dict.Add(k, new Stack<char>(new char[] {v}));
}

void ReverseStackNDeep<T>(Stack<T> s, int n)
{
    Queue<T> ts = new Queue<T>();
    for (int i = 0; i < n; i++)
    {
        ts.Enqueue(s.Pop());
    }
    for (int i = 0; i < n; i++)
    {
        s.Push(ts.Dequeue());
    }
}