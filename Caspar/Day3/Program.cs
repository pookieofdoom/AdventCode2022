// See https://aka.ms/new-console-template for more information
string[] inputs = File.ReadAllLines("input.txt");
Dictionary<char, int> itemsToPrioritize = new Dictionary<char, int>();
Dictionary<char, int> badgesToPrioritize = new Dictionary<char, int>();
List<HashSet<char>> badgeGroup = new List<HashSet<char>>();

foreach (var rucksack in inputs)
{
    // Part 1
    int lineLen = rucksack.Length;
    HashSet<char> rucksackItems = new HashSet<char>();
    for (int i = 0; i < lineLen / 2; i++)
    {
        rucksackItems.Add(rucksack[i]);
    }
    for (int i = lineLen / 2; i < lineLen; i++)
    {
        if(rucksackItems.Contains(rucksack[i]))
        {
            // Could initialize all possible values to 0 to skip this check
            int n;
            if (itemsToPrioritize.TryGetValue(rucksack[i], out n))
                itemsToPrioritize[rucksack[i]]++;
            else
                itemsToPrioritize[rucksack[i]] = 1;
            break;
        }
    }

    // Part 2
    badgeGroup.Add(new HashSet<char>(rucksack));
    if (badgeGroup.Count == 3)
    {
        badgeGroup[0].IntersectWith(badgeGroup[1]);
        badgeGroup[0].IntersectWith(badgeGroup[2]);
        char badge = badgeGroup[0].ElementAt(0);
        int n;
        if (badgesToPrioritize.TryGetValue(badge, out n))
            badgesToPrioritize[badge]++;
        else
            badgesToPrioritize[badge] = 1;
        badgeGroup.Clear();
    }
}

int count = 0;
foreach (var itemKVP in itemsToPrioritize)
{
    char item = itemKVP.Key;
    if (char.IsLower(item))
        count += ((int)item - (int)'a' + 1) * itemKVP.Value;
    else
        count += ((int)item - (int)'A' + 27) * itemKVP.Value;
}
System.Console.WriteLine("Part 1: " + count);

int count2 = 0;
foreach (var itemKVP in badgesToPrioritize)
{
    char item = itemKVP.Key;
    if (char.IsLower(item))
        count2 += ((int)item - (int)'a' + 1) * itemKVP.Value;
    else
        count2 += ((int)item - (int)'A' + 27) * itemKVP.Value;
}
System.Console.WriteLine("Part 2: " + count2);