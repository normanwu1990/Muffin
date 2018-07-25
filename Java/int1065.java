class MyCalendar {
    class Event{
        public int start;
        public int end;
        public Event(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    List<Event> events;
    
    public MyCalendar() {
        
        events = new LinkedList<Event>();
        
        
        
    }
    
    public boolean book(int start, int end) {
        Event e = new Event(start,end);
        if(events.size()==0){
            events.add(e);
            return true;
        }
        for(int i = 0;i<events.size();i++){
            Event curr = events.get(i);
            int currStart = curr.start;
            int currEnd = curr.end;
            if((currStart<=start&&start<currEnd)||(currStart<end&&end<=currEnd)||(start<=currStart&&end>=currEnd)){
                return false;
            }
            if(end<=currStart){
                events.add(i,e);
                return true;
            }
        }
        events.add(e);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
