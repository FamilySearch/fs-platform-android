This project has been deprecated in favor of [gedcomx-java](ttps://github.com/FamilySearch/gedcomx-java) 

The use gedcomx-java in Android add the following dependency to your project:

    compile ('org.gedcomx:gedcomx-model:1.0.158.M1') {
        exclude module: 'woodstox-core'
        exclude module: 'jaxb-impl'
    }

Welcome
-------

FamilySearch Android Platform is a library and samples that allow you to quickly begin and easily
write Android applications which connects with FamilySearch servers and manipulate 
GEDCOM X objects.

[See the developer site](https://familysearch.org/developers) for more information writing applications that use the FamilySearch API.
[See the wiki](https://github.com/FamilySearch/gedcomx/wiki) for more information about GEDCOM X.


Simple XML is used to serialize/deserialize the xml representation of the GedcomX and FamilySearch model objects.
[See the Simple XML site](http://simple.sourceforge.net/) for more information using Simple XML. 

The main way to build this is using gradle and/or Android Studio.


