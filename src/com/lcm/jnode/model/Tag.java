package com.lcm.jnode.model;

import com.jfinal.plugin.activerecord.Model;

public class Tag extends Model<Blog> {
    
    private static final long serialVersionUID = -2208881735662609833L;
    
    public static final Tag dao = new Tag();
    
}
