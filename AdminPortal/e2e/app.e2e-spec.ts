import { AdminPortalPage } from './app.po';

describe('admin-portal App', () => {
  let page: AdminPortalPage;

  beforeEach(() => {
    page = new AdminPortalPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
