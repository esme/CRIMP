Scores = new Mongo.Collection('scores');
CRIMP.schema.score = new SimpleSchema({
  climber_id: {
    label: 'ID of climber',
    type: String,
    min: 6,
    max: 6,
    denyUpdate: true
  },
  admin_id: {
    // TODO: Find a more efficient way of referencing admins
    label: 'ID of admin',
    type: String
  },
  category_id: {
    label: 'ID of category',
    type: String,
    min: 3,
    max: 3,
    denyUpdate: true
  },
  route_id: {
    label: 'ID of route',
    type: String,
    denyUpdate: true
  },
  unique_id: {
    label: 'Unique identifier (climber_id+route_id)',
    type: String,
    denyUpdate: true
  },
  score_string: {
    label: 'Raw scoring string',
    type: String,
    trim: false
  },
  score_top: {
    label: 'Attempts to top',
    type: Number
  },
  score_bonus: {
    label: 'Attempts to bonus',
    type: Number
  },
  updated_at: {
    type: Date,
    autoValue: function() {
      return new Date();
    }
  }
});


Scores.attachSchema(CRIMP.schema.score);

// TODO: Ensure admin-only access
Meteor.methods({
  // addScore: function(data) {
  //   Note: Integrated with addClimber because score documents
  //   are always tied to a climber
  // },

  findScore: function(data) {
    return Scores.find(data).fetch();
  },

  updateScore: function(data) {
    var selector = {
      unique_id: data.climber_id + data.route_id
    };

    // Removing fields which has denyUpdates
    try {
      delete data.climber_id;
      delete data.route_id;
      delete data.category_id;
      delete data.unique_id;
    } catch (e) {
      // lol fail.
    }

    data.score_top = CRIMP.scoring.calculateTop(data.score_string);
    data.score_bonus = CRIMP.scoring.calculateBonus(data.score_string);

    return Scores.update(selector, {$set: data},
                         function(error, updatedCount) {
      // TODO: Handle error
    });

  },

  deleteScore: function(data) {
    // TODO: This is probably not needed
  }
});