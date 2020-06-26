package org.example.bean;

public class TestParent extends TestBase{
    private String name;
    private String[] friendName;
    private TestChildren[] children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFriendName() {
        return friendName;
    }

    public void setFriendName(String[] friendName) {
        this.friendName = friendName;
    }

    public TestChildren[] getChildren() {
        return children;
    }

    public void setChildren(TestChildren[] children) {
        this.children = children;
    }
}
