import { OwishAdminClientPage } from './app.po';

describe('owish-admin-client App', function() {
  let page: OwishAdminClientPage;

  beforeEach(() => {
    page = new OwishAdminClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
