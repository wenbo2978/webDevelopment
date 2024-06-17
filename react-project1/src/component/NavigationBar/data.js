export const sideMenu = [
  {
    label: "Home",
    to: "/",
  },
  {
    label: "profile",
    to: "/profile",
    children: [
      {
        label: "Details",
        to: "details",
        children: [
          {
            label: "Loaction",
            to: "location",
          }
          

        ]
      }
    ]
  },
  {
    label: "Settings",
    to: "/settings",
    children: [
      {
        label: "Account",
        to: "account",
      },
      {
        label: "Security",
        to: "security",
        children: [
          {
            label: "login",
            to: "login",
          },
          {
            label: "register",
            to: "register",
          }
        ]
      },
      {
        label: "more",
        to: "#"
      }
    ]
  }
];