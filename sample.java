/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int totalimp = 0;
    Map<Integer, Employee> mc = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();
    public int getImportance(List<Employee> employees, int id) {
        for (int i=0;i<employees.size();i++) {
            mc.put(employees.get(i).id, employees.get(i));
        }
        System.out.println(mc);
        q.add(id);
        while (!q.isEmpty()) {
            int pollid = q.poll();
            List<Integer> sublist = mc.get(pollid).subordinates;
            totalimp = totalimp + mc.get(pollid).importance;
            for (int sb: sublist) {
                q.add(sb);
            }
        }
        return totalimp;
    }
}
