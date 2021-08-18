/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    // int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        int sum = find(map.get(id));
        // sum += map.get(id).importance;
        // find(map.get(id));
        return sum;

    }
    private int find(Employee emp) {
        int sum = emp.importance;
        List<Integer> subordinates = emp.subordinates;
        for(int subId : subordinates) {
            sum += find(map.get(subId));
            // sum += map.get(subId).importance;
            // find(map.get(subId));
        }
        return sum;
    }
}
