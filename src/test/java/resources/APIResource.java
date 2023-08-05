package resources;

	public enum APIResource{
		
		
		
		Addmapapi("/maps/api/place/add/json"),
		Deletemapapi("/maps/api/place/delete/json"),
		Getmapdetailsapi("/maps/api/place/get/json"),
		Putmapapi("/maps/api/place/get/json");
		
		private String resource;
		
		APIResource(String resource) {
			
			
			this.resource=resource;
					
		}
		
		public String getresource() {
			
			return resource;
			
			
		}
		
		
		
		
		
		
		
	

}
