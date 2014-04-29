package com.wagnerandade.coollection;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import static com.wagnerandade.coollection.Coollection.*;

import java.util.ArrayList;
import java.util.List;

public class ComplexCollectionTest {

    private ArrayList<ComplexA> complexCollection;

    @Before
    public void before() {
        complexCollection = new ArrayList<ComplexA>();
        complexCollection.add(new ComplexA(new ComplexB("Lion")));
        complexCollection.add(new ComplexA(new ComplexB("Cat")));
        complexCollection.add(new ComplexA(new ComplexB("Dog")));
        complexCollection.add(new ComplexA(new ComplexB("Bird")));
        complexCollection.add(new ComplexA(new ComplexB("Cat")));
        complexCollection.add(new ComplexA(new ComplexB(null)));
        complexCollection.add(new ComplexA(null));
        complexCollection.add(new ComplexA(new ComplexB("Unknown")));
    }

    @Test
    public void should_be_possible_create_a_filter_in_a_collection() {
        List<ComplexA> filtered = from(complexCollection).where("complexB.testField", eq("Cat")).all();
        assertThat(filtered.size(), is(2));
        assertThat(filtered.get(0).getComplexB().getTestField(), is("Cat"));
    }
}
