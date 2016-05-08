import { Mongo } from 'meteor/mongo';
import { ValidatedMethod } from 'meteor/mdg:validated-method';
import { SimpleSchema } from 'meteor/aldeed:simple-schema';


class EventsCollection extends Mongo.collection {
  insert() {
    return false;
  }
  update() {
    // TODO: Update denormalized data in Categories
    return false;
  }
  remove() {
    return false;
  }
}

export const Events = new EventsCollection('Events');
Events.schema = new SimpleSchema({
  event_name: {
    type: String,
  },
  categories: {
    type: [String]
    label: 'Reference to categories in event'
  },
  time_start: {
    type: Date,
    label: 'Starting time of event',
  },
  time_end: {
    type: Date,
    label: 'Starting time of event',
  },
  updated_at: {
    type: Date,
    optional: true,   // optional to pass ValidatedMethod
    autoValue: () => new Date(),
  },
});
Events.attachSchema(Events.schema);

if (ENVIRONMENT.NODE_ENV === 'production') {
  Events.deny({
    insert() { return true; },
    update() { return true; },
    remove() { return true; },
  });
}


Events.methods = {};
//Events.methods.insert =
