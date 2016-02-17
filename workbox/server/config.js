Meteor.startup(function () {
    ServiceConfiguration.configurations.upsert(
        { service: "google" },
        {
            $set: {
                clientId: "459392734214-g1vl6grldfkhc0j2q7kbbevq3jdhaneq.apps.googleusercontent.com",
                secret: "tDnnvwsE1tJQ1biJMnskKxSh"
            }
        }
    );

    ServiceConfiguration.configurations.upsert(
        { service: "facebook" },
        {
            $set: {
                appId: "104607049894079",
                secret: "4ecbb590d4609796f8edcdab014caf24"
            }
        }
    );

    ServiceConfiguration.configurations.upsert(
        { service: "twitter" },
        {
            $set: {
                consumerKey: "vhiRSkVEUxid22QoPcGmycVPK",
                secret: "mQBblkLZtuoSWPhFyXxr3UfaVE5pBNlOeybXTU2xQQrQBbXAMy"
            }
        }
    );
});