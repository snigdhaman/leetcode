package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC721AccountsMerge {
    class DSU {
        int[] parent;
        int[] size;

        DSU (int sz) {
            this.parent = new int[sz];
            this.size = new int[sz];

            for (int i = 0; i < sz; i++) {
                //Initialize all elements as disjoint in the beginning
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * Finds the root element of an element. Also does path compression
         */
        int find (int x) {
            //If element is pointing to itself then its the root element
            //return it
            if (x == parent[x]) {
                return x;
            }
            //Find the root element & return it
            //parent[x] is doing path compression to prevent multiple hops
            return parent[x] = find(parent[x]);
        }

        /**
         *Union sets a and b
         */
        void union (int a, int b) {
            int parentA = find(a);
            int parentB = find(b);

            //a and b are already part of the same set so no need to perform union
            if (parentA == parentB)
                return;

            //If b is smaller than a then merge b into a
            if (size[parentA] >= size[parentB]) {
                size[parentA] += size[parentB];
                parent[parentB] = parentA;
            }
            //If a is smaller than a then merge a into b
            else {
                size[parentB] += size[parentA];
                parent[parentA] = parentB;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountListSize = accounts.size();
        DSU dsu = new DSU(accountListSize);

        //Map of email to account index
        Map<String, Integer> emailMap = new HashMap<>();

        //Merge all accounts based on email ID
        for (int i = 0; i < accountListSize; i++) {
            int accountSize = accounts.get(i).size();

            List<String> account = accounts.get(i);
            //Get account name from index of 0
            String accountName = account.get(0);
            //Get emails from index 1 to accountSize
            for (int j = 1; j < accountSize; j++) {
                String email = account.get(j);

                if (!emailMap.containsKey(email)) {
                    emailMap.put(email, i);
                }
                else {
                    dsu.union(i, emailMap.get(email));
                }
            }
        }

        //Create a map of account root idx based on DSU find & map list of emails
        Map<Integer, List<String>> accountMap = new HashMap<>();
        for (String email : emailMap.keySet()) {
            int accountIdx = emailMap.get(email);
            int accountparent = dsu.find(accountIdx);

            if (!accountMap.containsKey(accountparent)) {
                accountMap.put(accountparent, new ArrayList<String>());
            }
            accountMap.get(accountparent).add(email);
        }

        //Sort the mails in alphabetical order
        List<List<String>> res = new ArrayList<>();
        for (Integer acntKey : accountMap.keySet()) {
            List<String> accountMailList = new ArrayList<>();
            List<String> emails = accountMap.get(acntKey);
            accountMailList.add(accounts.get(acntKey).get(0));
            accountMailList.addAll(emails.stream().sorted().collect(Collectors.toList()));
            res.add(accountMailList);
        }
        return res;
    }
}
